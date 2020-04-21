package net.scode.budmall.server.dto.ShoppingCart;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * 购物车商品信息Dto
 *
 * @author liuyoubin
 * @since 2020/4/20 - 23:37
 */
@Data
public class ShoppingCartProductDto {

    /**
     * 店铺id
     */
    @ApiModelProperty(value = "店铺id", dataType = "int", required = true)
    private int shopId;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id", dataType = "int", required = true)
    private int productId;

    /**
     * 商品SKU信息id
     */
    @ApiModelProperty(value = "商品SKU信息id", dataType = "int", required = true)
    private int productSkuId;

    /**
     * 店铺名称
     */
    @ApiModelProperty(value = "店铺名称", dataType = "String", required = true)
    @NotBlank(message = "店铺名称不能为空")
    private String shopName;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称", dataType = "String", required = true)
    @NotBlank(message = "商品名称不能为空")
    private String productName;

    /**
     * 商品图片1张,用于展示
     */
    @ApiModelProperty(value = "商品图片", dataType = "String", required = true)
    @NotBlank(message = "商品图片不能为空")
    private String productImg;

    /**
     * 商品单价
     */
    @ApiModelProperty(value = "商品单价", dataType = "BigDecimal", required = true)
    private BigDecimal productPrice;

    /**
     * 商品SKU名称
     */
    @ApiModelProperty(value = "商品SKU名称", dataType = "String", required = true)
    @NotBlank(message = "商品SKU名称不能为空")
    private String skuName;

    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量", dataType = "int", required = true)
    private int productAmount;

    /**
     * 是否选中
     */
    @ApiModelProperty(value = "是否选中 0不选中 1选中", dataType = "int")
    private int isSelected;

}
