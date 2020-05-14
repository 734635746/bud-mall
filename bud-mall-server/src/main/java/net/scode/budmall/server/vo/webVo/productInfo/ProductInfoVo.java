package net.scode.budmall.server.vo.webVo.productInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.scode.budmall.server.po.ProductSku;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Web端商品详情数据Vo对象,主要是管理页面的编辑商品显示
 *
 * @author liuyoubin
 * @since 2020/4/12 - 11:54
 */
@Data
public class ProductInfoVo {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id", dataType = "int", required = true)
    private int categoryId;

    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id", dataType = "int", required = true)
    private int brandId;

    /**
     * 店铺id
     */
    @ApiModelProperty(value = "店铺id", dataType = "int", required = true)
    private int shopId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称", dataType = "String", required = true)
    private String productName;

    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String productImg;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格", dataType = "BigDecimal", required = true)
    private BigDecimal price;

    /**
     * 原价
     */
    @ApiModelProperty(value = "原价", dataType = "BigDecimal")
    private BigDecimal originPrice;

    /**
     * 库存数量
     */
    @ApiModelProperty(value = "库存数量", dataType = "int")
    private int stock;

    /**
     * 销售数量
     */
    @ApiModelProperty(value = "销售数量", dataType = "int")
    private int sales;

    /**
     * 排序权重
     */
    @ApiModelProperty(value = "排序权重", dataType = "int", required = true)
    private int sort;

    /**
     * 商品介绍
     */
    @ApiModelProperty(value = "商品介绍", dataType = "String")
    private String intro;

    /**
     * 商品服务id，逗号隔开
     */
    @ApiModelProperty(value = "商品服务", dataType = "String")
    private String services;

    /**
     * 商品Sku列表
     */
    @ApiModelProperty(value = "商品Sku列表", dataType = "String", required = true)
    private List<ProductSku> skuList = new ArrayList<>();

}
