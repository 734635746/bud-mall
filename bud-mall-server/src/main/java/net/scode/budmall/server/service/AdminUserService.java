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

    /**
     * 删除管理员（将data_status设置为删除状态）
     * @param id 待删除管理员id
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}