package net.scode.budmall.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.ShoppingCartProductDao;
import net.scode.budmall.server.dto.ShoppingCart.ShoppingCartProductDto;
import net.scode.budmall.server.po.ShoppingCartProduct;
import net.scode.budmall.server.po.UserInfo;
import net.scode.budmall.server.service.ShoppingCartProductService;
import net.scode.budmall.server.service.UserInfoService;
import net.scode.budmall.server.web.UserAppContext;
import net.scode.commons.exception.ScodeRuntimeException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ShoppingCart对应service实现
 *
 * @author liuyoubin 2020年04月20日
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartProductDao, ShoppingCartProduct> implements ShoppingCartProductService {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public boolean saveShoppingCartProduct(ShoppingCartProductDto shoppingCartProductDto) {

        return updateShoppingCartProduct(0, shoppingCartProductDto);
    }

    @Override
    public boolean updateShoppingCartProduct(Integer id, ShoppingCartProductDto shoppingCartProductDto) {

        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct();
        BeanUtils.copyProperties(shoppingCartProductDto, shoppingCartProduct);

        //获取并设置用户id
        int userId = UserAppContext.getUserId();
        shoppingCartProduct.setUserId(userId);

        if (id == 0) {//添加操作
            return save(shoppingCartProduct);
        } else {//修改操作
            shoppingCartProduct.setId(id);
            return updateById(shoppingCartProduct);
        }

    }

    @Override
    public List<ShoppingCartProduct> listCurrent() {

        //获取用户id
        int userId = UserAppContext.getUserId();
        //构造查询参数
        QueryWrapper<ShoppingCartProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        return list(queryWrapper);
    }


    @Override
    public List<ShoppingCartProduct> listByMobile(String mobile) {
        //查询手机号对应用户的id
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.select("id");
        userInfoQueryWrapper.eq("mobile", mobile);
        UserInfo user = userInfoService.getOne(userInfoQueryWrapper);
        if (user == null) {
            throw new ScodeRuntimeException("用户不存在");
        }

        //构造查询参数
        QueryWrapper<ShoppingCartProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());

        return list(queryWrapper);
    }
}