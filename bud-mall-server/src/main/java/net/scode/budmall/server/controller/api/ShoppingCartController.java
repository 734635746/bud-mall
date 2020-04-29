package net.scode.budmall.server.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.shoppingCart.ShoppingCartProductDto;
import net.scode.budmall.server.po.ShoppingCartProduct;
import net.scode.budmall.server.service.ShoppingCartProductService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台购物车商品调用接口
 *
 * @author liuyoubin
 * @since 2020/4/20 - 23:08
 */
@Slf4j
@Api(tags = {"前台购物车商品调用接口"})
@RestController
@RequestMapping("/api/shoppingCart/product")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartProductService shoppingCartProductService;

    @ApiOperation(value = "用户购物车添加商品")
    @PostMapping
    public R saveShoppingCartProduct(
            @ApiParam(name = "shoppingCartProductDto", value = "购物车商品信息", required = true)
            @RequestBody @Validated ShoppingCartProductDto shoppingCartProductDto) {

        boolean isSuccess = shoppingCartProductService.saveShoppingCartProduct(shoppingCartProductDto);

        return isSuccess ? R.ok() : R.error("【用户购物车添加商品】操作失败");

    }

    @ApiOperation(value = "用户修改购物车商品信息")
    @PutMapping("/{id}")
    public R updateShoppingCartProduct(
            @ApiParam(name = "id", value = "购物车商品id", required = true)
            @PathVariable(value = "id") Integer id,
            @ApiParam(name = "shoppingCartProductDto", value = "购物车商品信息", required = true)
            @RequestBody @Validated ShoppingCartProductDto shoppingCartProductDto) {

        boolean isSuccess = shoppingCartProductService.updateShoppingCartProduct(id, shoppingCartProductDto);

        return isSuccess ? R.ok() : R.error("【用户修改购物车商品信息】操作失败");

    }

    @ApiOperation(value = "用户购物车删除商品")
    @DeleteMapping("/{id}")
    public R removeShoppingCartProduct(
            @ApiParam(name = "id", value = "购物车商品id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = shoppingCartProductService.removeById(id);

        return isSuccess ? R.ok() : R.error("【用户购物车删除商品】操作失败");

    }

    @ApiOperation(value = "获取当前用户购物车商品列表")
    @GetMapping("/list")
    public R listShoppingCartProduct() {

        List<ShoppingCartProduct> list = shoppingCartProductService.listCurrent();

        return R.data(list);

    }
}
