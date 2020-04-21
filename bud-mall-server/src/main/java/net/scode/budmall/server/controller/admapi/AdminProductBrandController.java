package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.service.ProductBrandService;
import net.scode.budmall.server.vo.productBrand.ProductBrandOptionVo;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台商品品牌管理接口
 *
 * @author liuyoubin
 * @since 2020/4/16 - 0:22
 */
@Slf4j
@Api(tags = {"后台商品品牌管理接口"})
@RestController
@RequestMapping("/admapi/product/brand")
public class AdminProductBrandController {

    @Autowired
    private ProductBrandService productBrandService;

    @ApiOperation(value = "查询品牌列表")
    @GetMapping("/list")
    public R list() {
        List<ProductBrandOptionVo> list = productBrandService.listProductBrandOption();
        return R.data(list);
    }

}
