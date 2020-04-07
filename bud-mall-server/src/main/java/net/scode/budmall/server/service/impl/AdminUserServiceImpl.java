package net.scode.budmall.server.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.consts.AdminUserConsts;
import net.scode.budmall.server.dao.AdminUserDao;
import net.scode.budmall.server.po.AdminUser;
import net.scode.budmall.server.service.AdminUserService;
import net.scode.commons.constant.Consts;
import net.scode.commons.constant.DataStatus;
import net.scode.commons.exception.ScodeException;
import net.scode.commons.exception.ScodeRuntimeException;
import net.scode.commons.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * AdminUser对应service实现
 * 
 * @author liuyoubin 2020年04月06日 
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserDao,AdminUser> implements AdminUserService {


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
        if(user==null){
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

        AdminUser adminUser = new AdminUser().setId(id).setDataStatus(DataStatus.DEL.getValue());

        return baseMapper.updateById(adminUser) == 1;

    }
}