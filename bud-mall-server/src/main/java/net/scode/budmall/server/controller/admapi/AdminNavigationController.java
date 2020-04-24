package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.navigation.CategoryNavigationDto;
import net.scode.budmall.server.po.Navigation;
import net.scode.budmall.server.service.NavigationService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台导航管理接口
 *
 * @author liuyoubin
 * @since 2020/4/23 - 20:43
 */
@Slf4j
@Api(tags = {"后台导航管理接口"})
@RestController
@RequestMapping("/admapi/navigation")
public class AdminNavigationController {

    @Autowired
    private NavigationService navigationService;


    @ApiOperation(value = "获取导航列表")
    @GetMapping("/list")
    public R listBannerByPosition() {

        List<Navigation> list = navigationService.list();

        return R.data(list);

    }

    @ApiOperation(value = "添加分类导航信息")
    @PostMapping("/ofCategory")
    public R saveCategoryNavigation(
            @ApiParam(name = "productBannerDto", value = "商品信息", required = true)
            @RequestBody @Validated CategoryNavigationDto categoryNavigationDto) {

        boolean isSuccess = navigationService.saveNavigation(categoryNavigationDto);

        return isSuccess ? R.ok() : R.error("【添加分类导航信息】操作失败");

    }

    @ApiOperation(value = "修改分类导航信息")
    @PutMapping("/ofCategory/{id}")
    public R updateCategoryNavigation(
            @ApiParam(name = "productBannerDto", value = "商品信息", required = true)
            @RequestBody @Validated CategoryNavigationDto categoryNavigationDto,
            @ApiParam(name = "id", value = "导航信息id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = navigationService.updateNavigation(id, categoryNavigationDto);

        return isSuccess ? R.ok() : R.error("【添加分类导航信息】操作失败");

    }

    @ApiOperation(value = "删除导航信息")
    @DeleteMapping("/{id}")
    public R removeNavigation(
            @ApiParam(name = "id", value = "导航信息id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = navigationService.removeById(id);

        return isSuccess ? R.ok() : R.error("【删除导航信息】操作失败");

    }
}
