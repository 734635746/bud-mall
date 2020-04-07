package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.consts.PermissionsEnum;
import net.scode.budmall.server.po.SysRole;

/**
 * SysRole对应Service
 *
 * @author tanghuang 2020年02月23日
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页搜索
     *
     * @param keywords
     * @param page
     * @return
     */
    Page<SysRole> pageSearch(String keywords, Page page);

    /**
     * 校验当前管理员是否具有指定权限
     * @param  permission 权限枚举
     * @return 是否具有指定权限
     */
    boolean checkPermission(PermissionsEnum permission);
}