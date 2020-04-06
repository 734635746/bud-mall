package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.po.AdminUser;
import net.scode.budmall.server.service.AdminUserService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    AdminUserService adminUserService;

    @ApiOperation(value = "管理员登陆接口",notes = "登陆成功则携带token返回")
    @PostMapping("/login")
    public R login(
            @ApiParam(name = "adminUser",value = "管理员信息对象",required = true)
            @RequestBody @Valid AdminUser adminUser){

        //校验管理员登陆，成功则返回token
        String token = adminUserService.login(adminUser);

        return R.ok().put("token", token);

    }


}
