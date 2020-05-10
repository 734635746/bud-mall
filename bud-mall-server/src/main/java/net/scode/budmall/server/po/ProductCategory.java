package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[product_category]对应实体类
 *
 * @author liuyoubin 2020年04月06日
 */
@Data
@TableName(value = "product_category")
@ApiModel(value = "表[product_category]的实体类")
public class ProductCategory {

    /**
     * 主键id
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
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", dataType = "java.util.Date")
    private java.util.Date createTime;

    /**
     * 通用状态,2正常,3删除
     */
    @ApiModelProperty(value = "通用状态,2正常,3删除", dataType = "int")
    private int dataStatus;

}