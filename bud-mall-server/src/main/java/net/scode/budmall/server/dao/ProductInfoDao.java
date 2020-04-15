package net.scode.budmall.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.scode.budmall.server.po.ProductInfo;

/**
 * 表[product_info]对应实体类
 *
 * @author liuyoubin 2020年04月10日
 */
public interface ProductInfoDao extends BaseMapper<ProductInfo> {

    /**
     * 插入商品数据,之所以不用MyBatis-plus提供的方法是为了获取插入后主键的值
     *
     * @param productInfo 商品数据
     */
    void insertProductInfo(ProductInfo productInfo);
}