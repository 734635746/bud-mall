package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.productInfo.ProductInfoDto;
import net.scode.budmall.server.query.ProductInfoQuery;
import net.scode.budmall.server.service.ProductInfoService;
import net.scode.budmall.server.vo.webVo.productInfo.ProductInfoVo;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 后台商品详情管理接口
 *
 * @author liuyoubin
 * @since 2020/4/10 - 22:56
 */
@Slf4j
@Api(tags = {"后台商品详情管理接口"})
@RestController
@RequestMapping("/admapi/product/info")
public class AdminProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @ApiOperation(value = "添加商品详情信息数据")
    @PostMapping
    public R addProductInfo(
            @ApiParam(name = "productInfoDto", value = "商品详情信息", required = true)
            @RequestBody @Validated ProductInfoDto productInfoDto) {

        boolean isSuccess = productInfoService.saveProductInfo(productInfoDto);

        return isSuccess ? R.ok() : R.error("【添加商品详情信息】操作失败");

    }

    @ApiOperation(value = "修改商品详细信息")
    @PutMapping("/{id}")
    public R updateProductInfo(
            @ApiParam(name = "id", value = "商品id", required = true)
            @PathVariable(value = "id") Integer id,
            @ApiParam(name = "productInfoDto", value = "商品详情信息", required = true)
            @RequestBody @Validated ProductInfoDto productInfoDto) {

        boolean isSuccess = productInfoService.updateProductInfoById(id, productInfoDto);

        return isSuccess ? R.ok() : R.error("【修改商品详情信息】操作失败");
    }

    @ApiOperation(value = "根据商品Id删除商品详情信息")
    @DeleteMapping("/{id}")
    public R deleteProductInfo(
            @ApiParam(name = "id", value = "商品id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = productInfoService.deleteProductInfoById(id);

        return isSuccess ? R.ok() : R.error("【删除商品详情信息】操作失败");

    }

    @ApiOperation(value = "支持条件搜索分页查询商品详情数据")
    @GetMapping("/{page}/{limit}")
    public R pageQueryProductInfos(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable(value = "page") Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable(value = "limit") Long limit,
            @ApiParam(name = "productInfoQuery", value = "商品查询信息封装对象")
                    ProductInfoQuery productInfoQuery) {


        HashMap<String, Object> map = productInfoService.pageQueryProductInfos(page, limit, productInfoQuery);

        return R.data(map);
    }

    @ApiOperation(value = "根据id查询商品详情数据")
    @GetMapping("/{id}")
    public R getProductInfo(
            @ApiParam(name = "id", value = "商品详情id", required = true)
            @PathVariable(value = "id") Integer id) {

        ProductInfoVo productInfoVo = productInfoService.getProductInfoById(id);

        return R.data(productInfoVo);
    }

}
