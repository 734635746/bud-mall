package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.productSpec.ProductSpecValueDto;
import net.scode.budmall.server.po.ProductSpecValue;

/**
 * ProductSpecValue对应Service
 *
 * @author liuyoubin 2020年05月14日
 */
public interface ProductSpecValueService extends IService<ProductSpecValue> {


    /**
     * 添加商品规格属性值
     *
     * @param productSpecValueDto 商品规格属性值Dto
     * @return 是否添加成功
     */
    boolean saveProductSpecValue(ProductSpecValueDto productSpecValueDto);

    /**
     * 修改商品规格属性值
     *
     * @param id                  商品规格属性值id
     * @param productSpecValueDto 商品规格属性值Dto
     * @return 是否修改成功
     */
    boolean updateProductSpecValue(Integer id, ProductSpecValueDto productSpecValueDto);
}