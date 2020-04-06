package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.po.AdminUser;

/**
 * AdminUser对应Service
 * 
 * @author liuyoubin 2020年04月06日 
 */
public interface AdminUserService extends IService<AdminUser> {

    /**
     * 管理员登陆校验
     * @param adminUser 管理员信息对象
     * @return token
     */
    String login(AdminUser adminUser);

}