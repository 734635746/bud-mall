package net.scode.budmall.server.vo.webVo.productInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Web端商品详情列表Vo对象,主要是给前台的商品详情列表进行展示
 *
 * @author liuyoubin
 * @since 2020/4/15 - 22:04
 */
@Data
public class ProductInfoListVo {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类id", dataType = "String")
    private String categoryName;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌id", dataType = "String")
    private String brandName;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String productImg;

    /**
     * 商品 价格/原价
     */
    @ApiModelProperty(value = "商品价格/原价", dataType = "BigDecimal")
    private String price;

    /**
     * 库存数量
     */
    @ApiModelProperty(value = "库存数量", dataType = "int")
    private int stock;

    /**
     * 销售数量
     */
    @ApiModelProperty(value = "销售数量", dataType = "int")
    private int sales;


}
