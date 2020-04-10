package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.product.ProductCategoryDto;
import net.scode.budmall.server.service.ProductCategoryService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyoubin
 * @since 2020/4/10 - 15:38
 */
@Slf4j
@Api(tags = {"商品分类管理接口"})
@RestController
@RequestMapping("/admapi/product/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @ApiOperation(value = "添加商品分类")
    @PostMapping
    public R addProductCategory(
            @ApiParam(name = "adminUser", value = "商品分类信息", required = true)
                    ProductCategoryDto productCategoryDto) {

        boolean isSuccess = productCategoryService.addProductCategory(productCategoryDto);

        return isSuccess ? R.ok() : R.error("【添加商品分类】操作失败");

    }


}
