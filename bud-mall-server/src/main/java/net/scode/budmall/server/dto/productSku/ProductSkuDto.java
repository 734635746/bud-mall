package net.scode.budmall.server.dto.productSku;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品Sku Dto
 *
 * @author liuyoubin
 * @since 2020/4/15 - 15:55
 */
@Data
public class ProductSkuDto {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int", required = true)
    private int id;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "自增id", dataType = "int", required = true)
    private int productId;

    /**
     * SKU名称
     */
    @ApiModelProperty(value = "SKU名称", dataType = "String", required = true)
    private String skuName;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格", dataType = "BigDecimal", required = true)
    private BigDecimal price;

    /**
     * 原价
     */
    @ApiModelProperty(value = "原价", dataType = "BigDecimal")
    private BigDecimal originPrice;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存", dataType = "int", required = true)
    private int stock;

    /**
     * 如果是第一个sku编码, 可以加图片
     */
    @ApiModelProperty(value = "图片", dataType = "String")
    private String picture;

}
