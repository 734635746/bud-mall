package net.scode.budmall.server.dto.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品分类Dto
 *
 * @author liuyoubin
 * @since 2020/4/10 - 18:10
 */
@Data
public class ProductCategoryDto {

    /**
     * 上级分类ID，一级为0
     */
    @ApiModelProperty(value = "上级分类ID，一级为0", dataType = "int", required = true)
    private int parentId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称", dataType = "String", required = true)
    private String categoryName;


    /**
     * 排序权重
     */
    @ApiModelProperty(value = "排序权重", dataType = "int", required = true)
    private int sort;

    /**
     * 分类图标
     */
    @ApiModelProperty(value = "分类图标", dataType = "String", required = false)
    private String icon;


}
