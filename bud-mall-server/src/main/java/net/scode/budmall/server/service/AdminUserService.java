package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.adminUser.AdminUserDto;
import net.scode.budmall.server.dto.adminUser.AdminUserLoginDto;
import net.scode.budmall.server.dto.adminUser.AdminUserPwdDto;
import net.scode.budmall.server.dto.adminUser.AdminUserUpdateDto;
import net.scode.budmall.server.po.AdminUser;
import net.scode.budmall.server.vo.webVo.adminUser.AdminUserVo;

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
     * @param adminUserLoginDto 管理员登陆Dto
     * @return token
     */
    String login(AdminUserLoginDto adminUserLoginDto);

    /**
     * 删除管理员（将data_status设置为删除状态）
     *
     * @param id 待删除管理员id
     * @return 是否删除成功
     */
    boolean removeAdminUserById(Integer id);

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
     * @param adminUserDto 管理员信息Dto对象
     * @return 是否添加成功
     */
    boolean saveAdminUser(AdminUserDto adminUserDto);

    /**
     * 修改管理员信息
     *
     * @param adminUserUpdateDto 管理员信息对象
     * @return 是否修改成功
     */
    boolean updateAdminUser(AdminUserUpdateDto adminUserUpdateDto);


    /**
     * 修改管理员密码
     *
     * @param id              管理员id
     * @param adminUserPwdDto 管理员密码对象
     * @return 是否修改成功
     */
    boolean updatePassword(Integer id, AdminUserPwdDto adminUserPwdDto);

    /**
     * 根据id获取管理员信息
     *
     * @param id 管理员id
     * @return 管理员信息Vo对象
     */
    AdminUserVo getAdminUserVoById(Integer id);
}