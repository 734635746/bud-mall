package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.productCategory.ProductCategoryDto;
import net.scode.budmall.server.dto.productCategory.ProductCategoryUpdateDto;
import net.scode.budmall.server.po.ProductCategory;
import net.scode.budmall.server.vo.appVo.productCategory.ProductCategoryAppVo;
import net.scode.budmall.server.vo.webVo.productCategory.ProductCategoryVo;

import java.util.List;

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
    boolean saveProductCategory(ProductCategoryDto productCategoryDto);

    /**
     * 修改商品分类信息
     *
     * @param productCategoryUpdateDto 商品分类修改信息Dto
     * @return 是否添加成功
     */
    boolean updateProductCategory(ProductCategoryUpdateDto productCategoryUpdateDto);

    /**
     * 获取商品分类嵌套列表
     *
     * @return 商品分类嵌套列表
     */
    List<ProductCategoryVo> listProductCategory();

    /**
     * 获取App端商品分类嵌套列表
     *
     * @return 商品分类嵌套列表
     */
    List<ProductCategoryAppVo> listWebProductCategory();

    /**
     * 删除商品分类
     *
     * @param categoryId 商品分类id
     * @return 是否删除成功
     */
    boolean removeByCategoryId(Integer categoryId);
}