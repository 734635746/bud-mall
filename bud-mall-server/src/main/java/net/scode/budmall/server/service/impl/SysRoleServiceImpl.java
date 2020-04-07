package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.consts.AdminUserConsts;
import net.scode.budmall.server.consts.PermissionsEnum;
import net.scode.budmall.server.dao.SysRoleDao;
import net.scode.budmall.server.po.SysPermission;
import net.scode.budmall.server.po.SysRole;
import net.scode.budmall.server.service.SysPermissionService;
import net.scode.budmall.server.service.SysRoleService;
import net.scode.budmall.server.web.AdminWebContext;
import net.scode.commons.constant.DataStatus;
import net.scode.commons.exception.ScodeRuntimeException;
import net.scode.commons.util.JwtUtil;
import net.scode.commons.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * SysRole对应service实现
 *
 * @author tanghuang 2020年02月23日
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public Page<SysRole> pageSearch(String keywords, Page page) {
        return this.getBaseMapper().pageSearch(keywords, page);
    }


    @Override
    public boolean checkPermission(PermissionsEnum permission) {

        //获取当前管理员的token
        String token = AdminWebContext.getToken();
        //获取角色Id
        Integer roleId = (Integer)JwtUtil.checkJWT(token, AdminUserConsts.JWT_SECRET).get("roleId");
        //通过角色Id获取角色对象
        SysRole sysRole = baseMapper.selectById(roleId);
        //验证角色存在且正常
        if(sysRole==null || sysRole.getDataStatus()!= DataStatus.NORMAL.getValue()){
            throw new ScodeRuntimeException("管理员的角色不存在！");
        }

        //获取权限Id集合
        String permissions = sysRole.getPermissions();
        String[] permissionIds = permissions.split(",");
        //根据权限Id集合获取权限对象,进而获取所有具体权限 判断是否具有指定权限
        for (String permissionId : permissionIds) {
            //获取权限对象
            SysPermission sysPermission = sysPermissionService.getById(permissionId);
            //权限对象正常
            if(sysPermission.getDataStatus()==DataStatus.NORMAL.getValue()){
                String permits = sysPermission.getPermits();
                String[] permitList = permits.split(",");
                for (String permit : permitList) {
                    if(permit.equals(permission.getPermit())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}