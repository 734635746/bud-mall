package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.productSpec.ProductSpecValueDto;
import net.scode.budmall.server.po.ProductSpecValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductSpecValue对应Service
 * 
 * @author liuyoubin 2020年05月14日 
 */
public interface ProductSpecValueService extends IService<ProductSpecValue> {


    /**
     * 添加Sku属性值
     * @param productSpecValueDto Sku属性值Dto
     * @return 是否添加成功
     */
    boolean saveProductSpecValue(ProductSpecValueDto productSpecValueDto);
}