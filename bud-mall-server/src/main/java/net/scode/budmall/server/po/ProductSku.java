package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 表[product_sku]对应实体类
 *
 * @author liuyoubin 2020年04月15日
 */
@Data
@TableName(value = "product_sku")
@ApiModel(value = "表[product_sku]的实体类")
public class ProductSku {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号", dataType = "int")
    private int productId;

    /**
     * SKU名称
     */
    @ApiModelProperty(value = "SKU名称", dataType = "String")
    private String skuName;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格", dataType = "BigDecimal")
    private BigDecimal price;

    /**
     * 原价
     */
    @ApiModelProperty(value = "原价", dataType = "BigDecimal")
    private BigDecimal originPrice;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存", dataType = "int")
    private int stock;

    /**
     * 如果是第一个sku编码, 可以加图片
     */
    @ApiModelProperty(value = "图片", dataType = "String")
    private String picture;

}