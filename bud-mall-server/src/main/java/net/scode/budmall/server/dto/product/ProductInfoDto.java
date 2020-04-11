package net.scode.budmall.server.dto.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * 商品详情Dto
 *
 * @author liuyoubin
 * @since 2020/4/10 - 23:09
 */
@Data
public class ProductInfoDto {

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id", dataType = "int", required = true)
    private int categoryId;

    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id", dataType = "int", required = true)
    private int bandId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称", dataType = "String", required = true)
    @NotBlank(message = "商品名称不能为空")
    private String productName;

    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String productImg;

    /**
     * 商品介绍
     */
    @ApiModelProperty(value = "商品介绍", dataType = "String")
    private String intro;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格", dataType = "BigDecimal", required = true)
    private BigDecimal price;

    /**
     * 排序权重
     */
    @ApiModelProperty(value = "排序权重", dataType = "int", required = true)
    private int sort;


}
