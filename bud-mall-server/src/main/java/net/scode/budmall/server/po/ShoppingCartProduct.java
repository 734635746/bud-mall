package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * 表[shopping_cart]对应实体类
 *
 * @author liuyoubin 2020年04月20日
 */
@Data
@TableName(value = "shopping_cart_product")
@ApiModel(value = "表[shopping_cart_product]的实体类")
public class ShoppingCartProduct{

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", dataType = "int")
    private int userId;

    /**
     * 店铺id
     */
    @ApiModelProperty(value = "店铺id", dataType = "int")
    private int shopId;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id", dataType = "int")
    private int productId;

    /**
     * 商品SKU信息id
     */
    @ApiModelProperty(value = "商品SKU信息id", dataType = "int")
    private int productSkuId;

    /**
     * 店铺名称
     */
    @ApiModelProperty(value = "店铺名称", dataType = "String")
    private String shopName;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /**
     * 商品图片1张,用于展示
     */
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String productImg;

    /**
     * 商品单价
     */
    @ApiModelProperty(value = "商品单价", dataType = "BigDecimal")
    private BigDecimal productPrice;

    /**
     * 商品SKU名称
     */
    @ApiModelProperty(value = "商品SKU名称", dataType = "String")
    private String skuName;

    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量", dataType = "int")
    @Min(value = 1, message = "商品数量最少为1")
    private int productAmount;

    /**
     * 是否选中
     */
    @ApiModelProperty(value = "是否选中 0不选中 1选中", dataType = "int")
    private int isSelected;

}