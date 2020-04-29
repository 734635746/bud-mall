package net.scode.budmall.server.vo.appVo.productInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * app端，商品列表信息Vo
 *
 * @author liuyoubin
 * @since 2020/4/28 - 12:36
 */
@Data
public class ProductListAppVo {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;


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
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格", dataType = "BigDecimal")
    private BigDecimal price;


}
