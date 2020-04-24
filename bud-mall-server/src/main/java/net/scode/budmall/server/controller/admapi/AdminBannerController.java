package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.banner.OuterChainBannerDto;
import net.scode.budmall.server.dto.banner.ProductBannerDto;
import net.scode.budmall.server.po.Banner;
import net.scode.budmall.server.service.BannerService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台横幅管理接口
 *
 * @author liuyoubin
 * @since 2020/4/22 - 22:26
 */
@Slf4j
@Api(tags = {"后台横幅管理接口"})
@RestController
@RequestMapping("/admapi/banner")
public class AdminBannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation(value = "获取指定位置的横幅列表")
    @GetMapping("/list")
    public R listBannerByPosition(
            @ApiParam(name = "position", value = "横幅位置,1第一处横幅 2第二处横幅", required = true)
            @RequestParam(value = "position") Integer position) {

        List<Banner> list = bannerService.listBannerByPosition(position);

        return R.data(list);

    }

    @ApiOperation(value = "添加商品横幅信息")
    @PostMapping("/ofProduct")
    public R saveOuterChainBanner(
            @ApiParam(name = "productBannerDto", value = "商品横幅信息", required = true)
            @RequestBody @Validated ProductBannerDto productBannerDto) {

        boolean isSuccess = bannerService.saveBanner(productBannerDto);

        return isSuccess ? R.ok() : R.error("【添加商品横幅信息】操作失败");

    }

    @ApiOperation(value = "添加外链横幅信息")
    @PostMapping("/ofOuterChain")
    public R saveProductBanner(
            @ApiParam(name = "outerChainBannerDto", value = "外链横幅信息", required = true)
            @RequestBody @Validated OuterChainBannerDto outerChainBannerDto) {

        boolean isSuccess = bannerService.saveBanner(outerChainBannerDto);

        return isSuccess ? R.ok() : R.error("【添加外链横幅信息】操作失败");

    }

    @ApiOperation(value = "修改商品横幅信息")
    @PutMapping("/ofProduct/{id}")
    public R updateOuterChainBanner(
            @ApiParam(name = "productBannerDto", value = "商品横幅信息", required = true)
            @RequestBody @Validated ProductBannerDto productBannerDto,
            @ApiParam(name = "id", value = "商品横幅id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = bannerService.updateBanner(id, productBannerDto);

        return isSuccess ? R.ok() : R.error("【修改商品横幅信息】操作失败");

    }

    @ApiOperation(value = "修改外链横幅信息")
    @PutMapping("/ofOuterChain/{id}")
    public R updateProductBanner(
            @ApiParam(name = "outerChainBannerDto", value = "外链横幅信息", required = true)
            @RequestBody @Validated OuterChainBannerDto outerChainBannerDto,
            @ApiParam(name = "id", value = "外链横幅信息id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = bannerService.updateBanner(id, outerChainBannerDto);

        return isSuccess ? R.ok() : R.error("【修改外链横幅信息】操作失败");

    }

    @ApiOperation(value = "删除横幅信息")
    @DeleteMapping("/{id}")
    public R removeBanner(
            @ApiParam(name = "id", value = "横幅信息id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = bannerService.removeById(id);

        return isSuccess ? R.ok() : R.error("【删除横幅信息】操作失败");

    }

}
