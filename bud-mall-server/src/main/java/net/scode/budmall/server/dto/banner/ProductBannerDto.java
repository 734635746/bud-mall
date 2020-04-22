package net.scode.budmall.server.dto.banner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 商品横幅信息Dto
 *
 * @author liuyoubin
 * @since 2020/4/22 - 23:17
 */
@Data
public class ProductBannerDto {

    /**
     * 横幅标题
     */
    @ApiModelProperty(value = "横幅标题", dataType = "String")
    private String title;

    /**
     * 横幅图片地址
     */
    @ApiModelProperty(value = "横幅图片地址", dataType = "String", required = true)
    @NotBlank(message = "横幅图片地址不能为空")
    private String image;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id", dataType = "int", required = true)
    private int productId;

    /**
     * sku信息id
     */
    @ApiModelProperty(value = "sku信息id", dataType = "int", required = true)
    private int skuId;


    /**
     * 横幅位置,1第一处横幅 2第二处横幅
     */
    @ApiModelProperty(value = "横幅位置", dataType = "int", required = true)
    @Min(value = 1, message = "未指定横幅的位置")
    private int position;

}
