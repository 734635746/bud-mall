package net.scode.budmall.server.dto.productCategory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 商品分类修改信息Dto
 *
 * @author liuyoubin
 * @since 2020/4/10 - 21:20
 */
@Data
public class ProductCategoryUpdateDto {

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id", dataType = "String", required = true)
    private String categoryId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称", dataType = "String", required = true)
    @NotNull(message = "分类名称不能为空")
    @NotBlank(message = "请输入分类名称")
    private String categoryName;


    /**
     * 排序权重
     */
    @ApiModelProperty(value = "排序权重", dataType = "int", required = true)
    private int sort;

    /**
     * 分类图标
     */
    @ApiModelProperty(value = "分类图标", dataType = "String")
    private String icon;
}
