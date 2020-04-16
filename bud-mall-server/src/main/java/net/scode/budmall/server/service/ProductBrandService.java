package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.po.ProductBrand;
import net.scode.budmall.server.vo.productBrand.ProductBrandOptionVo;

import java.util.List;

/**
 * ProductBrand对应Service
 *
 * @author liuyoubin 2020年04月06日
 */
public interface ProductBrandService extends IService<ProductBrand> {

    /**
     * 查询商品品牌选项列表
     *
     * @return 结果列表
     */
    List<ProductBrandOptionVo> listProductBrandOption();

}