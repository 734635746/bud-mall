package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.ProductInfoDao;
import net.scode.budmall.server.po.ProductInfo;
import net.scode.budmall.server.service.ProductInfoService;
import org.springframework.stereotype.Service;

/**
 * ProductInfo对应service实现
 * 
 * @author liuyoubin 2020年04月10日 
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoDao,ProductInfo> implements ProductInfoService {

}