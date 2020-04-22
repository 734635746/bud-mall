package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.banner.OuterChainBannerDto;
import net.scode.budmall.server.dto.banner.ProductBannerDto;
import net.scode.commons.core.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "添加商品横幅信息")
    @PostMapping("/ofOuterChain")
    public R saveOuterChainBanner(
            @ApiParam(name = "productBannerDto", value = "商品横幅信息", required = true)
            @RequestBody @Validated ProductBannerDto productBannerDto) {


        return R.ok();

    }

    @ApiOperation(value = "添加外链横幅信息")
    @PostMapping("/ofProduct")
    public R saveProductBanner(
            @ApiParam(name = "outerChainBannerDto", value = "外链横幅信息", required = true)
            @RequestBody @Validated OuterChainBannerDto outerChainBannerDto) {


        return R.ok();

    }

}
