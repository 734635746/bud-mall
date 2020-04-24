package net.scode.budmall.server.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.service.NavigationService;
import net.scode.budmall.server.vo.navigation.NavigationVo;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台导航管理接口
 *
 * @author liuyoubin
 * @since 2020/4/23 - 20:22
 */
@Slf4j
@Api(tags = {"前台导航管理接口"})
@RestController
@RequestMapping("/api/navigation")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @ApiOperation(value = "获取导航列表")
    @GetMapping("/list")
    public R listNavigations() {

        List<NavigationVo> list = navigationService.listNavigations();

        return R.data(list);

    }

}
