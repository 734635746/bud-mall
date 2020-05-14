package net.scode.budmall.server.dto.productSpec;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liuyoubin
 * @since 2020/5/14 - 18:29
 */
@Data
public class ProductSpecDto {

    /**
     * 规格名称
     */
    @ApiModelProperty(value = "规格名称", dataType = "String")
    @NotBlank(message = "规格名称不能为空")
    private String specName;

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
