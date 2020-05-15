package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.productSpec.ProductSpecDto;
import net.scode.budmall.server.po.ProductSpec;
import net.scode.budmall.server.vo.webVo.productSpec.ProductSpecItemVo;

import java.util.List;

/**
 * ProductSpec对应Service
 *
 * @author liuyoubin 2020年05月14日
 */
public interface ProductSpecService extends IService<ProductSpec> {

    /**
     * 添加商品规格属性
     *
     * @param productSpecDto 商品规格属性Dto
     * @return 是否添加成功
     */
    boolean saveProductSpec(ProductSpecDto productSpecDto);

    /**
     * 修改商品规格属性
     *
     * @param id             商品规格id
     * @param productSpecDto 商品规格属性Dto
     * @return 是否添加成功
     */
    boolean updateProductSpec(Integer id, ProductSpecDto productSpecDto);

    /**
     * 列出所有的商品规格属性及其值
     *
     * @return 结果列表
     */
    List<ProductSpecItemVo> listProductSpecAndValue();


    /**
     * 删除商品规格及其属性值
     *
     * @param id 商品规格id
     * @return 是否删除成功
     */
    boolean removeProductSpec(Integer id);
}