package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 表[product_info]对应实体类
 *
 * @author liuyoubin 2020年04月10日
 */
@Data
@TableName(value = "product_info")
@ApiModel(value = "表[product_info]的实体类")
public class ProductInfo {


    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id", dataType = "int")
    private int categoryId;

    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id", dataType = "int")
    private int bandId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称", dataType = "String")
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
    @ApiModelProperty(value = "商品价格", dataType = "BigDecimal")
    private BigDecimal price;

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