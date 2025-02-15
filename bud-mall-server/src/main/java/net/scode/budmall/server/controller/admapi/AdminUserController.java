package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.adminUser.AdminUserDto;
import net.scode.budmall.server.dto.adminUser.AdminUserLoginDto;
import net.scode.budmall.server.dto.adminUser.AdminUserPwdDto;
import net.scode.budmall.server.dto.adminUser.AdminUserUpdateDto;
import net.scode.budmall.server.po.AdminUser;
import net.scode.budmall.server.service.AdminUserService;
import net.scode.budmall.server.vo.webVo.adminUser.AdminUserVo;
import net.scode.budmall.server.web.AdminWebContext;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

/**
 * 后台管理员用户信息接口
 *
 * @author liuyoubin
 * @since 2020/4/6 - 16:55
 */
@Slf4j
@Api(tags = {"后台管理员用户信息接口"})
@RestController
@RequestMapping("/admapi/user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;


    @ApiOperation(value = "管理员登陆接口", notes = "登陆成功则携带token返回")
    @PostMapping("/login")
    public R login(
            @ApiParam(name = "adminUser", value = "管理员信息", required = true)
            @RequestBody @Validated AdminUserLoginDto adminUserLoginDto) {

        //校验管理员登陆，成功则返回token
        String token = adminUserService.login(adminUserLoginDto);

        return R.ok().put("token", token);

    }

    @ApiOperation(value = "获取管理员信息", notes = "返回管理员信息")
    @GetMapping("/info")
    public R info() {
        int userId = AdminWebContext.getAdminUserId();
        AdminUser adminUser = adminUserService.getById(userId);
        return R.data(adminUser);
    }

    @ApiOperation(value = "根据id获取管理员信息")
    @GetMapping("/{id}")
    public R getAdminUserById(
            @ApiParam(name = "id", value = "管理员id", required = true)
            @PathVariable(value = "id") @NotNull(message = "id不能为空") Integer id) {


        AdminUserVo adminUserVo = adminUserService.getAdminUserVoById(id);
        return R.data(adminUserVo);
    }

    @ApiOperation(value = "根据Id删除管理员")
    @DeleteMapping("/{id}")
    public R removeAdminUser(
            @ApiParam(name = "id", value = "管理员id", required = true)
            @PathVariable(value = "id") @NotNull(message = "id不能为空") Integer id) {

        //删除管理员
        boolean isSuccess = adminUserService.removeAdminUserById(id);

        return isSuccess ? R.ok() : R.error("【删除管理员】操作失败");

    }

    @ApiOperation(value = "根据Id禁止管理员登陆")
    @DeleteMapping("/{id}/loginPermit")
    public R forbidAdminUserLogin(
            @ApiParam(name = "id", value = "管理员id", required = true)
            @PathVariable(value = "id") @NotNull(message = "id不能为空") Integer id) {

        //禁止管理员登陆实际上就是将管理员的状态设置成禁用状态
        //将指定管理员的状态设置成禁用状态
        boolean isSuccess = adminUserService.forbidLoginById(id);

        return isSuccess ? R.ok() : R.error("【禁止管理员登陆】操作失败");
    }

    @ApiOperation(value = "支持根据名称分页查询管理员")
    @GetMapping("/{page}/{limit}")
    public R pageQueryAdminUsers(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable(value = "page") Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable(value = "limit") Long limit,
            @ApiParam(name = "nickname", value = "搜索条件:管理员名称", required = false)
            @RequestParam(value = "nickname", required = false) String nickname) {

        //分页查询
        HashMap<String, Object> map = adminUserService.pageQueryAdminUsers(page, limit, nickname);

        return R.data(map);

    }

    @ApiOperation(value = "添加管理员")
    @PostMapping
    public R addAdminUser(
            @ApiParam(name = "adminUser", value = "管理员信息对象", required = true)
            @RequestBody @Validated AdminUserDto adminUserDto) {
        //新增管理员
        boolean isSuccess = adminUserService.saveAdminUser(adminUserDto);

        return isSuccess ? R.ok() : R.error("【添加管理员】操作失败！");
    }

    @ApiOperation(value = "更新管理员信息")
    @PutMapping
    public R updateAdminUser(
            @ApiParam(name = "adminUser", value = "管理员信息对象", required = true)
            @RequestBody @Validated AdminUserUpdateDto adminUserUpdateDto) {
        //修改管理员
        boolean isSuccess = adminUserService.updateAdminUser(adminUserUpdateDto);

        return isSuccess ? R.ok() : R.error("【修改管理员】操作失败！");
    }

    @ApiOperation(value = "修改管理员密码")
    @PutMapping("/password/{id}")
    public R updatePassword(
            @ApiParam(name = "id", value = "管理员id", required = true)
            @PathVariable(value = "id") Integer id,
            @ApiParam(name = "adminUser", value = "管理员密码信息", required = true)
            @RequestBody AdminUserPwdDto adminUserPwdDto) {

        boolean isSuccess = adminUserService.updatePassword(id, adminUserPwdDto);

        return isSuccess ? R.ok() : R.error("【修改管理员密码】操作失败！");
    }
}
