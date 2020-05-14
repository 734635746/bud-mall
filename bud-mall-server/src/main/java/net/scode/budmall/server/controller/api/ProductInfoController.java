package net.scode.budmall.server.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.service.ProductInfoService;
import net.scode.budmall.server.vo.appVo.productInfo.ProductListAppVo;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台商品详情调用接口
 *
 * @author liuyoubin
 * @since 2020/4/28 - 11:39
 */
@Slf4j
@Api(tags = {"前台商品详情调用接口"})
@RestController
@RequestMapping("/api/product/info")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @ApiOperation(value = "获取商品列表")
    @GetMapping("/list")
    public R listProductInfo() {

        List<ProductListAppVo> list = productInfoService.listAppProductInfo();

        return R.data(list);
    }


}
