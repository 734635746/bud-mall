package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[product_brand]对应实体类
 *
 * @author liuyoubin 2020年04月06日
 */
@Data
@TableName(value = "product_brand")
@ApiModel(value = "表[product_brand]的实体类")
public class ProductBrand {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称", dataType = "String")
    private String brandName;

    /**
     * 分类ID
     */
    @ApiModelProperty(value = "分类ID", dataType = "int")
    private int categoryId;

    /**
     * 首字母
     */
    @ApiModelProperty(value = "首字母", dataType = "char")
    private char firstLetter;

    /**
     * 品牌logo
     */
    @ApiModelProperty(value = "品牌logo", dataType = "String")
    private String brandLogo;

    /**
     * 专区大图
     */
    @ApiModelProperty(value = "专区大图", dataType = "String")
    private String brandImg;

    /**
     * 简单介绍
     */
    @ApiModelProperty(value = "简单介绍", dataType = "String")
    private String intro;

    /**
     * 品牌下商品数量
     */
    @ApiModelProperty(value = "品牌下商品数量", dataType = "int")
    private int productNum;

    /**
     * 排序权重
     */
    @ApiModelProperty(value = "排序权重", dataType = "int")
    private int sort;

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