package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import net.scode.budmall.server.dao.ProductCategoryDao;
import net.scode.budmall.server.po.ProductCategory;
import net.scode.budmall.server.service.ProductCategoryService;
import net.scode.commons.constant.DataStatus;
import org.springframework.stereotype.Service;

/**
 * ProductCategory对应service实现
 *
 * @author liuyoubin 2020年04月06日
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategory> implements ProductCategoryService {

    @Override
    public boolean addProductCategory(ProductCategory productCategory) {

        if (productCategory.getDataStatus() == 0) {
            productCategory.setDataStatus(DataStatus.NORMAL.getValue());
        }

        /**
         * category_id的设置规则
         *
         * parent_id==0
         *       category_id = 最大一级分类id+1
         *       如果是第一条一级分类记录则设置成1000
         *
         * parent_id!=0
         *      每次新增的时候，根据parent_id查最大的子分类id，
         *      有最大的子分类id，那么这时候的category_id=parent_id下最大的子分类id+1，
         *      没有的话，category_id=parent_id*1000
         *
         */
        if (productCategory.getParentId() == 0) {//一级分类
            QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id", 0);
            queryWrapper.orderByDesc("category_id");
            ProductCategory maxIdCategory = baseMapper.selectOne(queryWrapper);
            //存在最大分类id
            if (maxIdCategory != null) {
                productCategory.setCategoryId(maxIdCategory.getCategoryId() + 1);
            } else {//不存在最大分类id
                productCategory.setCategoryId(1000);
            }
        } else {
            //根据parent_id查最大的子分类id
            QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id", productCategory.getParentId());
            queryWrapper.orderByDesc("category_id");
            ProductCategory maxIdCategory = baseMapper.selectOne(queryWrapper);
            //存在最大的子分类id
            if (maxIdCategory != null) {
                productCategory.setCategoryId(maxIdCategory.getCategoryId() + 1);
            } else {//不存在最大的子分类id
                productCategory.setCategoryId(productCategory.getParentId() * 1000);
            }

        }

        return SqlHelper.retBool(baseMapper.insert(productCategory));
    }
}