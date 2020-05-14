package net.scode.budmall.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.scode.budmall.server.po.ProductSpec;
import net.scode.budmall.server.vo.webVo.productSpec.ProductSpecItemVo;

import java.util.List;

/**
 * 表[product_spec]对应实体类
 * 
 * @author liuyoubin 2020年05月14日 
 */
public interface ProductSpecDao extends BaseMapper<ProductSpec> {

    List<ProductSpecItemVo> listProductSpecItem();
    
}