package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.ProductServiceDao;
import net.scode.budmall.server.po.ProductService;
import net.scode.budmall.server.service.ProductServiceService;
import org.springframework.stereotype.Service;

/**
 * ProductService对应service实现
 * 
 * @author liuyoubin 2020年04月15日 
 */
@Service
public class ProductServiceServiceImpl extends ServiceImpl<ProductServiceDao,ProductService> implements ProductServiceService {

}