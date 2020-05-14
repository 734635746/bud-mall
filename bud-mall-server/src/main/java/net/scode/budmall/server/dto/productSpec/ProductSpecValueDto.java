package net.scode.budmall.server.dto.productSpec;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liuyoubin
 * @since 2020/5/14 - 19:41
 */
@Data
public class ProductSpecValueDto {

    /**
     * 商品规格ID
     */
    @ApiModelProperty(value = "商品规格ID", dataType = "int")
    private int specId;

    /**
     * 商品规格值名称
     */
    @ApiModelProperty(value = "商品规格值名称", dataType = "String")
    @NotBlank(message = "规格值不能为空")
    private String specValueName;

    /**
     * 是否可视
     */
    @ApiModelProperty(value = "是否可视", dataType = "int")
    private int isVisible;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", dataType = "int")
    private int sort;

}
