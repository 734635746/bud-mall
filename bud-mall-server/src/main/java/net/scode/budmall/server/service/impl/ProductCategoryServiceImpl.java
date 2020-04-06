package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.ProductCategoryDao;
import net.scode.budmall.server.po.ProductCategory;
import net.scode.budmall.server.service.ProductCategoryService;
import org.springframework.stereotype.Service;

/**
 * ProductCategory对应service实现
 * 
 * @author liuyoubin 2020年04月06日 
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao,ProductCategory> implements ProductCategoryService {

}