package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.productCategory.ProductCategoryDto;
import net.scode.budmall.server.dto.productCategory.ProductCategoryUpdateDto;
import net.scode.budmall.server.po.ProductCategory;
import net.scode.budmall.server.vo.ProductCategoryVo;

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
     * 获取所有商品分类嵌套列表
     *
     * @return 商品分类嵌套列表
     */
    List<ProductCategoryVo> listAllProductCategory();

}