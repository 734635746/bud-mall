package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.ProductSpecDao;
import net.scode.budmall.server.dto.productSpec.ProductSpecDto;
import net.scode.budmall.server.po.ProductSpec;
import net.scode.budmall.server.service.ProductSpecService;
import net.scode.budmall.server.vo.webVo.productSpec.ProductSpecItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductSpec对应service实现
 * 
 * @author liuyoubin 2020年05月14日 
 */
@Service
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecDao,ProductSpec> implements ProductSpecService {
    
    
    @Override
    public boolean saveProductSpec(ProductSpecDto productSpecDto) {

        ProductSpec productSpec = new ProductSpec();
        BeanUtils.copyProperties(productSpecDto, productSpec);

        return save(productSpec);
    }

    @Override
    public List<ProductSpecItemVo> listProductSpecAndValue() {
        
        List<ProductSpecItemVo> list = baseMapper.listProductSpecItem();
        
        return list;
    }


}