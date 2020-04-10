package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.product.ProductCategoryDto;
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
     * @param productCategoryDto 商品分类信息Dto
     * @return 是否添加成功
     */
    boolean addProductCategory(ProductCategoryDto productCategoryDto);
}