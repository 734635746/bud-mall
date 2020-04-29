package net.scode.budmall.server.vo.appVo.productCategory;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * App端，分类列表商品分类Vo
 *
 * @author liuyoubin
 * @since 2020/4/28 - 20:30
 */
@Data
public class ProductCategoryAppVo {

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id", dataType = "int")
    @TableId
    private int categoryId;

    /**
     * 上级分类ID，一级为0
     */
    @ApiModelProperty(value = "上级分类ID，一级为0", dataType = "int")
    private int parentId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称", dataType = "String")
    private String categoryName;


    /**
     * 分类图标
     */
    @ApiModelProperty(value = "分类图标", dataType = "String")
    private String icon;

    /**
     * 下级分类集合
     */
    @ApiModelProperty(value = "下级分类集合", dataType = "List")
    private List<ProductCategoryAppVo> children = new ArrayList<>();

}
