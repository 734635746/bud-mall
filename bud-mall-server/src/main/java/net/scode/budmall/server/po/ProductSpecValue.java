package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[product_spec_value]对应实体类
 *
 * @author liuyoubin 2020年05月14日
 */
@Data
@TableName(value = "product_spec_value")
@ApiModel(value = "表[product_spec_value]的实体类")
public class ProductSpecValue {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 商品规格ID
     */
    @ApiModelProperty(value = "商品规格ID", dataType = "int")
    private int specId;

    /**
     * 商品规格值名称
     */
    @ApiModelProperty(value = "商品规格值名称", dataType = "String")
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