package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.productSpec.ProductSpecDto;
import net.scode.budmall.server.dto.productSpec.ProductSpecValueDto;
import net.scode.budmall.server.service.ProductSpecService;
import net.scode.budmall.server.service.ProductSpecValueService;
import net.scode.budmall.server.vo.webVo.productSpec.ProductSpecItemVo;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuyoubin
 * @since 2020/5/14 - 17:26
 */
@Slf4j
@Api(tags = {"后台商品sku属性管理接口"})
@RestController
@RequestMapping("/admapi/product/spec")
public class AdminProductSpec {

    @Autowired
    private ProductSpecService productSpecService;

    @Autowired
    private ProductSpecValueService productSpecValueService;

    @ApiOperation(value = "添加商品规格属性")
    @PostMapping
    public R saveProductSpec(
            @ApiParam(name = "productBannerDto", value = "商品规格属性信息", required = true)
            @RequestBody @Validated ProductSpecDto productSpecDto) {

        boolean isSuccess = productSpecService.saveProductSpec(productSpecDto);

        return isSuccess ? R.ok() : R.error("【添加商品规格属性】操作失败");

    }

    @ApiOperation(value = "修改商品规格属性")
    @PutMapping("/{id}")
    public R updateProductSpec(
            @ApiParam(name = "productBannerDto", value = "商品规格属性信息", required = true)
            @RequestBody @Validated ProductSpecDto productSpecDto,
            @ApiParam(name = "id", value = "商品规格id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = productSpecService.updateProductSpec(id, productSpecDto);

        return isSuccess ? R.ok() : R.error("【修改商品规格属性】操作失败");

    }

    @ApiOperation(value = "添加商品规格属性值")
    @PostMapping("/value")
    public R saveProductSpecValue(
            @ApiParam(name = "productBannerDto", value = "商品规格属性值", required = true)
            @RequestBody @Validated ProductSpecValueDto productSpecValueDto) {

        boolean isSuccess = productSpecValueService.saveProductSpecValue(productSpecValueDto);

        return isSuccess ? R.ok() : R.error("【添加商品规格属性值】操作失败");

    }

    @ApiOperation(value = "修改商品规格属性值")
    @PutMapping("/value/{id}")
    public R updateProductSpecValue(
            @ApiParam(name = "productBannerDto", value = "商品规格属性值", required = true)
            @RequestBody @Validated ProductSpecValueDto productSpecValueDto,
            @ApiParam(name = "id", value = "商品规格属性值id", required = true)
            @PathVariable(value = "id") Integer id) {


        boolean isSuccess = productSpecValueService.updateProductSpecValue(id, productSpecValueDto);

        return isSuccess ? R.ok() : R.error("【修改商品规格属性值】操作失败");

    }

    @ApiOperation(value = "删除商品规格")
    @DeleteMapping("/{id}")
    public R deleteProductSpec(
            @ApiParam(name = "id", value = "商品规格id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = productSpecService.removeProductSpec(id);

        return isSuccess ? R.ok() : R.error("【删除商品规格】操作失败");
    }

    @ApiOperation(value = "删除商品规格属性值")
    @DeleteMapping("/value/{id}")
    public R deleteProductSpecValue(
            @ApiParam(name = "id", value = "商品规格属性值id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = productSpecValueService.removeById(id);

        return isSuccess ? R.ok() : R.error("【删除商品规格属性值】操作失败");

    }

    @ApiOperation(value = "列出所有的商品规格属性及其值")
    @GetMapping("/list")
    public R listProductSpecAndValue() {

        List<ProductSpecItemVo> list = productSpecService.listProductSpecAndValue();

        return R.data(list);
    }


}
