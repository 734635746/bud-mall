package net.scode.budmall.server.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import net.scode.budmall.server.consts.AdminUserConsts;
import net.scode.budmall.server.dao.AdminUserDao;
import net.scode.budmall.server.dto.adminUser.AdminUserDto;
import net.scode.budmall.server.dto.adminUser.AdminUserLoginDto;
import net.scode.budmall.server.dto.adminUser.AdminUserPwdDto;
import net.scode.budmall.server.dto.adminUser.AdminUserUpdateDto;
import net.scode.budmall.server.po.AdminUser;
import net.scode.budmall.server.service.AdminUserService;
import net.scode.budmall.server.util.PageQueryResultMapUtil;
import net.scode.budmall.server.vo.adminUser.AdminUserVo;
import net.scode.commons.constant.Consts;
import net.scode.commons.constant.DataStatus;
import net.scode.commons.exception.ScodeRuntimeException;
import net.scode.commons.util.JwtUtil;
import net.scode.commons.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * AdminUser对应service实现
 *
 * @author liuyoubin 2020年04月06日
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserDao, AdminUser> implements AdminUserService {


    @Override
    public String login(AdminUserLoginDto adminUserLoginDto) {

        //构造查询对象
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", adminUserLoginDto.getAccount());
        //查询对象
        AdminUser user = baseMapper.selectOne(queryWrapper);

        //验证账号状态
        if (user == null || user.getDataStatus() == DataStatus.DEL.getValue()) {
            throw new ScodeRuntimeException(Consts.FAILED_CODE, "账号不存在,请检查账号！");
        } else if (user.getDataStatus() == DataStatus.FORBID.getValue()) {
            throw new ScodeRuntimeException(Consts.FAILED_CODE, "账号处于禁用状态,请联系管理员！");
        } else if (!SecureUtil.md5(adminUserLoginDto.getLoginPwd()).equals(user.getLoginPwd())) {
            throw new ScodeRuntimeException(Consts.FAILED_CODE, "密码错误,请重新输入密码！");
        }

        //构造需要保存到token的信息
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("account", user.getAccount());
        claims.put("roleId", user.getRoleId());
        claims.put("dataStatus", user.getDataStatus());

        //生成token并返回
        return JwtUtil.geneJsonWebToken(claims, AdminUserConsts.JWT_SECRET);

    }


    @Override
    public boolean deleteById(Integer id) {
        return updateAdminUserDataStatus(id, DataStatus.DEL) == 1;
    }

    @Override
    public boolean forbidLoginById(Integer id) {
        return updateAdminUserDataStatus(id, DataStatus.FORBID) == 1;
    }


    @Override
    public HashMap<String, Object> pageQueryAdminUsers(Long page, Long limit, String nickname) {
        //判断分页参数和合法性
        if (page <= 0 || limit <= 0) {
            throw new ScodeRuntimeException("分页参数不合法！");
        }
        //构造分页查询对象
        Page<AdminUser> userPage = new Page<>(page, limit);
        //构造查询参数对象
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        //排除处于删除状态的管理员
        queryWrapper.ne("data_status", DataStatus.DEL.getValue());
        //如果搜索条件存在
        if (StringUtils.isNotBlank(nickname)) {
            queryWrapper.eq("nickname", nickname);
        }

        //查询
        baseMapper.selectPage(userPage, queryWrapper);

        //对查询结果集进行封装并返回
        return PageQueryResultMapUtil.getResultMap(userPage, AdminUserVo.class);

    }

    @Override
    public boolean saveAdminUser(AdminUserDto adminUserDto) {

        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserDto, adminUser);

        //将密码进md5加密
        adminUser.setLoginPwd(SecureUtil.md5(adminUser.getLoginPwd()));
        //如果没有指定头像使用默认头像
        if (StringUtil.isBlank(adminUser.getAvatar())) {
            adminUser.setAvatar(AdminUserConsts.DEFAULT_AVATAR);
        }
        //由于int在java中默认值是0,所以dataStatus为0插入数据库时data_status默认值不生效,所以进行一次判断
        if (adminUser.getDataStatus() == 0) {
            adminUser.setDataStatus(DataStatus.NORMAL.getValue());
        }

        //添加管理员并返回结果
        return SqlHelper.retBool(baseMapper.insert(adminUser));
    }

    @Override
    public boolean updateAdminUser(AdminUserUpdateDto adminUserUpdateDto) {

        //构造更新对象
        UpdateWrapper<AdminUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", adminUserUpdateDto.getId());
        if (StringUtils.isBlank(adminUserUpdateDto.getAvatar())) {
            updateWrapper.set("avatar", AdminUserConsts.DEFAULT_AVATAR);
        } else {
            updateWrapper.set("avatar", adminUserUpdateDto.getAvatar());
        }
        updateWrapper.set("nickname", adminUserUpdateDto.getNickname());
        updateWrapper.set("role_id", adminUserUpdateDto.getRoleId());
        updateWrapper.set("data_status", adminUserUpdateDto.getDataStatus());

        return update(updateWrapper);
    }

    @Override
    public boolean updatePassword(Integer id, AdminUserPwdDto adminUserPwdDto) {
        //构造查询对象
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        //查询对象
        AdminUser user = baseMapper.selectOne(queryWrapper);

        //验证账号状态
        if (user == null || user.getDataStatus() == DataStatus.DEL.getValue()) {
            throw new ScodeRuntimeException(Consts.FAILED_CODE, "账号不存在,请检查账号！");
        }

        //修改密码
        UpdateWrapper<AdminUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("login_pwd", SecureUtil.md5(adminUserPwdDto.getNewPassword()));

        return update(updateWrapper);
    }

    @Override
    public AdminUserVo getAdminUserVoById(Integer id) {

        AdminUser adminUser = baseMapper.selectById(id);
        //验证账号状态
        if (adminUser == null || adminUser.getDataStatus() == DataStatus.DEL.getValue()) {
            throw new ScodeRuntimeException(Consts.FAILED_CODE, "账号不存在,请检查账号！");
        }
        AdminUserVo adminUserVo = new AdminUserVo();
        BeanUtils.copyProperties(adminUser, adminUserVo);

        return adminUserVo;
    }

    /**
     * 修改管理员的状态
     *
     * @param id         待修改的管理员id
     * @param dataStatus 指定的状态
     * @return 成功修改的数量
     */
    private int updateAdminUserDataStatus(Integer id, DataStatus dataStatus) {
        AdminUser adminUser = new AdminUser().setId(id).setDataStatus(dataStatus.getValue());
        return baseMapper.updateById(adminUser);
    }

}