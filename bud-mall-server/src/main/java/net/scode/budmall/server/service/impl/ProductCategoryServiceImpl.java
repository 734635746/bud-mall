package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.consts.ProductConsts;
import net.scode.budmall.server.dao.ProductCategoryDao;
import net.scode.budmall.server.dto.productCategory.ProductCategoryDto;
import net.scode.budmall.server.dto.productCategory.ProductCategoryUpdateDto;
import net.scode.budmall.server.po.ProductCategory;
import net.scode.budmall.server.service.ProductCategoryService;
import net.scode.budmall.server.vo.appVo.productCategory.ProductCategoryAppVo;
import net.scode.budmall.server.vo.webVo.productCategory.ProductCategoryVo;
import net.scode.commons.constant.DataStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductCategory对应service实现
 *
 * @author liuyoubin 2020年04月06日
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategory> implements ProductCategoryService {


    @Override
    public boolean saveProductCategory(ProductCategoryDto productCategoryDto) {

        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(productCategoryDto, productCategory);

        //设置默认图标
        if (StringUtils.isBlank(productCategoryDto.getIcon())) {
            productCategory.setIcon(ProductConsts.DEFAULT_CATEGORY_ICNO);
        }

        productCategory.setDataStatus(DataStatus.NORMAL.getValue());
        /**
         * category_id的设置规则
         *
         *      每次新增的时候，根据parent_id查最大的子分类id，
         *      有最大的子分类id，那么这时候的category_id=parent_id下最大的子分类id+1，
         *      没有的话，
         *          category_id=parent_id*1000 (如果是一级分类就设置为1000)
         *
         */
        //根据parent_id查最大的子分类id
        ProductCategory maxIdCategory = baseMapper.selectMaxIdCategoryByParentId(productCategory.getParentId());
        //存在最大的子分类id
        if (maxIdCategory != null) {
            productCategory.setCategoryId(maxIdCategory.getCategoryId() + 1);
        } else {//不存在最大的子分类id
            if (productCategory.getParentId() == 0) {//一级分类
                productCategory.setCategoryId(1000);
            } else {
                productCategory.setCategoryId(productCategory.getParentId() * 1000);
            }
        }


        return save(productCategory);
    }


    @Override
    public boolean updateProductCategory(ProductCategoryUpdateDto productCategoryUpdateDto) {
        //设置默认图标
        if (StringUtils.isBlank(productCategoryUpdateDto.getIcon())) {
            productCategoryUpdateDto.setIcon(ProductConsts.DEFAULT_CATEGORY_ICNO);
        }

        //指定更新字段
        UpdateWrapper<ProductCategory> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("category_name", productCategoryUpdateDto.getCategoryName());
        updateWrapper.set("sort", productCategoryUpdateDto.getSort());
        updateWrapper.set("icon", productCategoryUpdateDto.getIcon());
        //指定category_id
        updateWrapper.eq("category_id", productCategoryUpdateDto.getCategoryId());

        return update(updateWrapper);
    }


    @Override
    public List<ProductCategoryVo> listProductCategory() {

        //获取parent_id为0的所有商品分类列表
        return baseMapper.listProductCategoryByParentId(0);

    }

    @Override
    public List<ProductCategoryAppVo> listWebProductCategory() {
        //获取parent_id为0的所有App端商品分类列表
        return baseMapper.listAppProductCategoryByParentId(0);
    }

    @Override
    public boolean removeByCategoryId(Integer categoryId) {

        UpdateWrapper<ProductCategory> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("data_status", DataStatus.DEL.getValue());
        updateWrapper.likeRight("category_id", categoryId);

        return update(updateWrapper);

    }
}