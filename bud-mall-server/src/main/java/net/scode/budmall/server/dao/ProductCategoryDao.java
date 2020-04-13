package net.scode.budmall.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.scode.budmall.server.po.ProductCategory;
import net.scode.budmall.server.vo.ProductCategoryVo;

import java.util.List;

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

    /**
     * 获取指定parent_id的商品分类列表
     *
     * @param parentId 父级分类Id
     * @return 商品分类嵌套列表
     */
    List<ProductCategoryVo> listProductCategoryByParentId(int parentId);
}