package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.consts.PermissionsEnum;
import net.scode.budmall.server.po.AdminUser;
import net.scode.budmall.server.service.AdminUserService;
import net.scode.budmall.server.service.SysRoleService;
import net.scode.budmall.server.web.AdminWebContext;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 管理员用户信息后台接口
 * @author liuyoubin
 * @since 2020/4/6 - 16:55
 */
@Slf4j
@Api(tags = {"管理员用户信息后台接口"})
@RestController
@RequestMapping("/admapi/user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "管理员登陆接口",notes = "登陆成功则携带token返回")
    @PostMapping("/login")
    public R login(
            @ApiParam(name = "adminUser",value = "管理员信息对象",required = true)
            @RequestBody @Valid AdminUser adminUser){

        //校验管理员登陆，成功则返回token
        String token = adminUserService.login(adminUser);

        return R.ok().put("token", token);

    }

    @ApiOperation(value = "根据Id删除管理员")
    @DeleteMapping("/{id}")
    public R deleteAdminUser(
            @ApiParam(name = "id",value = "管理员id",required = true)
            @PathVariable(value = "id") @NotNull(message = "id不能为空") Integer id){

        //校验当前管理员是否具有删除管理员的权限
        boolean isHas = sysRoleService.checkPermission(PermissionsEnum.ADMIN_DELETE);
        if(!isHas){return R.error("权限不足,操作失败！");}

        //删除管理员
        boolean isSuccess = adminUserService.deleteById(id);

        return isSuccess?R.ok():R.error("删除管理员失败");

    }
}
