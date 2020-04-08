package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.po.AdminUser;

import java.util.HashMap;

/**
 * AdminUser对应Service
 *
 * @author liuyoubin 2020年04月06日
 */
public interface AdminUserService extends IService<AdminUser> {

    /**
     * 管理员登陆校验
     *
     * @param adminUser 管理员信息对象
     * @return token
     */
    String login(AdminUser adminUser);

    /**
     * 删除管理员（将data_status设置为删除状态）
     *
     * @param id 待删除管理员id
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);

    /**
     * 禁止管理员登陆（将data_status设置为禁用状态）
     *
     * @param id 待禁用管理员id
     * @return 是否禁用成功
     */
    boolean forbidLoginById(Integer id);

    /**
     * 分页查询管理员
     *
     * @param page     单前页码
     * @param limit    每页几条数据
     * @param nickname 搜索条件：管理员名称
     * @return 查询结果集映射
     */
    HashMap<String, Object> pageQueryAdminUsers(Long page, Long limit, String nickname);

    /**
     * 添加管理员
     *
     * @param adminUser 管理员信息对象
     * @return 是否添加成功
     */
    boolean addAdminUser(AdminUser adminUser);

    /**
     * 修改管理员信息
     *
     * @param adminUser 管理员信息对象
     * @return 是否修改成功
     */
    boolean updateAdminUser(AdminUser adminUser);

}