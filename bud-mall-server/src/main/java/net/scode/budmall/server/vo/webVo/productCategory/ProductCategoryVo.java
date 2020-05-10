package net.scode.budmall.server.vo.webVo.productCategory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类嵌套Vo对象
 *
 * @author liuyoubin
 * @since 2020/4/13 - 11:57
 */
@Data
public class ProductCategoryVo {

    /**
     * id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id", dataType = "String")
    private String categoryId;

    /**
     * 上级分类ID，一级为0
     */
    @ApiModelProperty(value = "上级分类ID，一级为0", dataType = "String")
    private String parentId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称", dataType = "String")
    private String categoryName;

    /**
     * 分类下的商品数量
     */
    @ApiModelProperty(value = "分类下的商品数量", dataType = "int")
    private int productNum;

    /**
     * 排序权重
     */
    @ApiModelProperty(value = "排序权重", dataType = "int")
    private int sort;

    /**
     * 分类图标
     */
    @ApiModelProperty(value = "分类图标", dataType = "String")
    private String icon;

    /**
     * 下级分类集合
     */
    @ApiModelProperty(value = "下级分类集合", dataType = "List")
    private List<ProductCategoryVo> children = new ArrayList<>();

}
