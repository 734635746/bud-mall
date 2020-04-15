package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.productInfo.ProductInfoDto;
import net.scode.budmall.server.po.ProductInfo;
import net.scode.budmall.server.query.ProductInfoQuery;
import net.scode.budmall.server.vo.ProductInfoVo;

import java.util.HashMap;

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
     */
    boolean saveProductInfo(ProductInfoDto productInfoDto);

    /**
     * 根据Id删除商品详情信息
     *
     * @param id 商品id
     * @return 是否删除成功
     */
    boolean deleteProductInfoById(Integer id);

    /**
     * 修改商品详情信息
     *
     * @param id             商品id
     * @param productInfoDto 商品信息
     * @return 是否修改成功
     */
    boolean updateProductInfoById(Integer id, ProductInfoDto productInfoDto);

    /**
     * 支持条件搜索分页查询商品详情数据
     *
     * @param page             当前页码
     * @param limit            每页记录数
     * @param productInfoQuery 查询信息封装对象
     * @return 查询结果映射
     */
    HashMap<String, Object> pageQueryProductInfos(Long page, Long limit, ProductInfoQuery productInfoQuery);

    /**
     * 根据id查询商品详细信息
     *
     * @param id 商品id
     * @return 商品详情数据
     */
    ProductInfoVo getProductInfoById(Integer id);
}