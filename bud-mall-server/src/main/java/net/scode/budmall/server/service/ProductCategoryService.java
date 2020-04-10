package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.po.ProductCategory;

/**
 * ProductCategory对应Service
 *
 * @author liuyoubin 2020年04月06日
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    /**
     * 添加商品分类
     *
     * @param productCategory 商品分类信息
     * @return 是否添加成功
     */
    boolean addProductCategory(ProductCategory productCategory);
}