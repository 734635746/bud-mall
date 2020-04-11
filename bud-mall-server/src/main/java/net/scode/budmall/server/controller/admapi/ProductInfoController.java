package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.product.ProductInfoDto;
import net.scode.budmall.server.service.ProductInfoService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 后台商品详情管理接口
 *
 * @author liuyoubin
 * @since 2020/4/10 - 22:56
 */
@Slf4j
@Api(tags = {"商品详情管理接口"})
@RestController
@RequestMapping("/admapi/product/info")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @ApiOperation(value = "添加商品详情信息数据")
    @PostMapping
    public R addProductInfo(
            @ApiParam(name = "productInfoDto", value = "商品详情信息", required = true)
            @Validated ProductInfoDto productInfoDto) {

        boolean isSuccess = productInfoService.addProductInfo(productInfoDto);

        return isSuccess ? R.ok() : R.error("【添加商品详情信息】操作失败");

    }

    @ApiOperation(value = "根据商品Id删除商品详情信息")
    @DeleteMapping("/{id}")
    public R deleteProductInfo(
            @ApiParam(name = "id", value = "商品id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = productInfoService.deleteProductInfoById(id);

        return isSuccess ? R.ok() : R.error("【删除商品详情信息】操作失败");


    }

}
