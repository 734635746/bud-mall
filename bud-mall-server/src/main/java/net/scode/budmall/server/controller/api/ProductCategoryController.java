package net.scode.budmall.server.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.service.ProductCategoryService;
import net.scode.budmall.server.vo.appVo.productCategory.ProductCategoryAppVo;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台商品分类调用接口
 *
 * @author liuyoubin
 * @since 2020/4/28 - 13:43
 */
@Slf4j
@Api(tags = {"前台商品分类调用接口"})
@RestController
@RequestMapping("/api/product/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @ApiOperation(value = "商品分类列表")
    @GetMapping("/list")
    public R listProductCategory() {

        List<ProductCategoryAppVo> list = productCategoryService.listWebProductCategory();

        return R.data(list);
    }

}
