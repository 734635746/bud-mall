package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.productSku.ProductSkuDto;
import net.scode.budmall.server.po.ProductSku;

import java.util.List;

/**
 * ProductSku对应Service
 *
 * @author liuyoubin 2020年04月15日
 */
public interface ProductSkuService extends IService<ProductSku> {

    /**
     * 保存商品的sku数据
     *
     * @param id      对应的商品id
     * @param skuList sku数据列表
     */
    void saveSkuList(int id, List<ProductSkuDto> skuList);
}