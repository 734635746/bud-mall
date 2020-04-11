package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.product.ProductInfoDto;
import net.scode.budmall.server.po.ProductInfo;

/**
 * ProductInfo对应Service
 *
 * @author liuyoubin 2020年04月10日
 */
public interface ProductInfoService extends IService<ProductInfo> {

    /**
     * 添加商品详情信息数据
     *
     * @param productInfoDto 商品详情Dto
     * @return 是否添加成功
     */
    boolean addProductInfo(ProductInfoDto productInfoDto);

    /**
     * 根据Id删除商品详情信息
     *
     * @param id 商品id
     * @return
     */
    boolean deleteProductInfoById(Integer id);
}