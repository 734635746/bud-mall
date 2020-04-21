package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.po.ShoppingCartProduct;
import net.scode.budmall.server.service.ShoppingCartProductService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台购物车商品管理接口
 *
 * @author liuyoubin
 * @since 2020/4/21 - 16:24
 */
@Slf4j
@Api(tags = {"后台购物车商品管理接口"})
@RestController
@RequestMapping("/admapi/shoppingCart/product")
public class AdminShoppingCartController {

    @Autowired
    private ShoppingCartProductService shoppingCartProductService;

    @ApiOperation(value = "后台删除用户购物车商品信息")
    @DeleteMapping("/{id}")
    public R removeShoppingCartProduct(
            @ApiParam(name = "id", value = "购物车商品id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = shoppingCartProductService.removeById(id);

        return isSuccess ? R.ok() : R.error("【后台删除用户购物车商品信息】操作失败");

    }

    @ApiOperation(value = "后台获取用户购物车商品信息列表")
    @GetMapping("/list")
    public R listShoppingCartProduct(
            @ApiParam(name = "mobile", value = "用户手机号", required = true)
            @RequestParam String mobile) {

        List<ShoppingCartProduct> list = shoppingCartProductService.listByMobile(mobile);

        return R.data(list);

    }
}
