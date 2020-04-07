package net.scode.budmall.server.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.consts.AdminUserConsts;
import net.scode.budmall.server.dao.AdminUserDao;
import net.scode.budmall.server.po.AdminUser;
import net.scode.budmall.server.service.AdminUserService;
import net.scode.budmall.server.vo.AdminUserVo;
import net.scode.commons.constant.Consts;
import net.scode.commons.constant.DataStatus;
import net.scode.commons.exception.ScodeRuntimeException;
import net.scode.commons.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * AdminUser对应service实现
 *
 * @author liuyoubin 2020年04月06日
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserDao, AdminUser> implements AdminUserService {


    @Override
    public String login(AdminUser adminUser) {

        //构造查询对象
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", adminUser.getAccount());
        System.out.println(adminUser.getAccount());
        queryWrapper.eq("login_pwd", SecureUtil.md5(adminUser.getLoginPwd()));
        System.out.println(adminUser.getLoginPwd());
        System.out.println(SecureUtil.md5(adminUser.getLoginPwd()));
        //查询对象
        AdminUser user = baseMapper.selectOne(queryWrapper);

        //查询失败
        if (user == null) {
            throw new ScodeRuntimeException(Consts.FAILED_CODE, "登陆失败,请检查账号密码！");
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

        //构造查询对象
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("data_status", DataStatus.DEL);//排除处于删除状态的管理员
        if (nickname != null) {
            queryWrapper.eq("nickname", nickname);
        }

        //查询
        baseMapper.selectPage(userPage, queryWrapper);

        return new AdminUserVoPageQueryResultMap(userPage);

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

    /**
     * 管理员信息Vo对象分页查询结果映射内部类
     */
    class AdminUserVoPageQueryResultMap extends HashMap<String, Object> {

        AdminUserVoPageQueryResultMap(Page<AdminUser> userPage) {

            put("records", getAdminUserVoList(userPage.getRecords()));
            put("total", userPage.getTotal());
            put("size", userPage.getSize());
            put("pages", userPage.getPages());
            put("current", userPage.getCurrent());

        }

        /**
         * 将AdminUser集合转成AdminUserVo集合
         */
        private List<AdminUserVo> getAdminUserVoList(List<AdminUser> adminUserList) {
            ArrayList<AdminUserVo> adminUserVoList = new ArrayList<>();

            for (AdminUser adminUser : adminUserList) {
                AdminUserVo adminUserVo = new AdminUserVo();
                BeanUtils.copyProperties(adminUser, adminUserVo);
                adminUserVoList.add(adminUserVo);
            }
            return adminUserVoList;

        }
    }
}