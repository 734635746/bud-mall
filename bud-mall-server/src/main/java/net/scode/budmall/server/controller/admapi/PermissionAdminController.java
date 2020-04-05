package net.scode.budmall.server.controller.admapi;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.po.SysPermission;
import net.scode.budmall.server.po.SysRole;
import net.scode.budmall.server.service.SysPermissionService;
import net.scode.budmall.server.service.SysRoleService;
import net.scode.commons.constant.DataStatus;
import net.scode.commons.core.R;
import net.scode.commons.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限与角色管理
 *
 * @author tanghuang 2020年02月23日
 */
@Slf4j
@Api(tags = {"权限与角色管理"})
@RestController
@RequestMapping("/admapi/permission")
public class PermissionAdminController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 获取权限列表
     *
     * @param keywords
     * @param page
     * @return
     */
    @ApiOperation(value = "获取权限列表")
    @GetMapping("/page")
    public R page(@ApiParam(value = "搜索关键词") @RequestParam(required = false, defaultValue = "") String keywords, Page page) {
        Page<SysPermission> pageData = sysPermissionService.pageSearch(keywords, page);
        return R.data(pageData);
    }

    /**
     * 保存权限<br>
     * id大于0表示修改
     *
     * @param sysPermission
     * @return
     */
    @ApiOperation(value = "保存权限", notes = "id大于0表示修改")
    @PostMapping()
    public R save(@RequestBody SysPermission sysPermission) {
        if (sysPermission.getId() > 0) {
            sysPermissionService.updateById(sysPermission);
        } else {
            sysPermission.setUrl(Convert.notNull(sysPermission.getUrl()));
            sysPermission.setKeyName(Convert.notNull(sysPermission.getKeyName()));
            sysPermission.setPermits(Convert.notNull(sysPermission.getPermits()));
            sysPermission.setComponent(Convert.notNull(sysPermission.getComponent()));
            sysPermission.setIcon(Convert.notNull(sysPermission.getIcon()));
            sysPermission.setDataStatus(DataStatus.NORMAL.getValue());
            sysPermissionService.save(sysPermission);
        }
        return R.ok();
    }

    /**
     * 删除权限
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除权限")
    @DeleteMapping()
    public R del(@ApiParam(value = "权限id") @RequestParam int id) {
        if (id > 0) {
            sysPermissionService.removeById(id);
        }
        return R.ok();
    }

    /**
     * 获取角色列表
     *
     * @param keywords
     * @param page
     * @return
     */
    @ApiOperation(value = "获取角色列表")
    @GetMapping("/role/page")
    public R pageRole(@ApiParam(value = "搜索关键词") @RequestParam(required = false, defaultValue = "") String keywords, Page page) {
        Page<SysRole> pageData = sysRoleService.pageSearch(keywords, page);
        return R.data(pageData);
    }

    /**
     * 保存角色<br>
     * id大于0表示修改
     *
     * @param role
     * @return
     */
    @ApiOperation(value = "保存角色", notes = "id大于0表示修改")
    @PostMapping("/role")
    public R saveRole(@RequestBody SysRole role) {
        if (role.getId() > 0) {
            sysRoleService.updateById(role);
        } else {
            role.setDataStatus(DataStatus.NORMAL.getValue());
            sysRoleService.save(role);
        }
        return R.ok();
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role")
    public R delRole(@ApiParam(value = "角色id") @RequestParam int id) {
        if (id > 0) {
            sysRoleService.removeById(id);
        }
        return R.ok();
    }

}
