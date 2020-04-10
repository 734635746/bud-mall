package net.scode.budmall.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.scode.budmall.server.po.ProductCategory;

/**
 * 表[product_category]对应实体类
 *
 * @author liuyoubin 2020年04月06日
 */
public interface ProductCategoryDao extends BaseMapper<ProductCategory> {

    /**
     * 根据parentId查找分类id最大的数据
     *
     * @param parentId 父级分类Id
     * @return ProductCategory
     */
    ProductCategory selectMaxIdCategoryByParentId(int parentId);
}