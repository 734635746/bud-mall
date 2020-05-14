package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.productSpec.ProductSpecDto;
import net.scode.budmall.server.dto.productSpec.ProductSpecValueDto;
import net.scode.budmall.server.po.ProductSpec;
import net.scode.budmall.server.vo.webVo.productSpec.ProductSpecItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductSpec对应Service
 * 
 * @author liuyoubin 2020年05月14日 
 */
public interface ProductSpecService extends IService<ProductSpec> {

    /**
     * 添加Sku属性
     * @param productSpecDto Sku属性Dto
     * @return 是否添加成功
     */
    boolean saveProductSpec(ProductSpecDto productSpecDto);

    /**
     * 列出所有的商品规格属性及其值
     * @return 结果列表
     */
    List<ProductSpecItemVo> listProductSpecAndValue();
    
}