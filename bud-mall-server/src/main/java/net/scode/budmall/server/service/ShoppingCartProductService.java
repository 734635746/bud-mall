package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.shoppingCart.ShoppingCartProductDto;
import net.scode.budmall.server.po.ShoppingCartProduct;

import java.util.List;


/**
 * ShoppingCart对应Service
 *
 * @author liuyoubin 2020年04月20日
 */
public interface ShoppingCartProductService extends IService<ShoppingCartProduct> {

    /**
     * 添加购物车商品信息
     *
     * @param shoppingCartProductDto 购物车商品信息Dto
     * @return 是否添加成功
     */
    boolean saveShoppingCartProduct(ShoppingCartProductDto shoppingCartProductDto);

    /**
     * 修改购物车商品信息
     *
     * @param id                     商品id
     * @param shoppingCartProductDto 购物车商品信息Dto
     * @return 是否修改成功
     */
    boolean updateShoppingCartProduct(Integer id, ShoppingCartProductDto shoppingCartProductDto);

    /**
     * 获取当前用户的购物车商品列表
     *
     * @return 购物车商品列表
     */
    List<ShoppingCartProduct> listCurrent();

    /**
     * 获取指定手机号用户的购物车商品列表
     *
     * @param mobile 手机号
     * @return 购物车商品列表
     */
    List<ShoppingCartProduct> listByMobile(String mobile);
}