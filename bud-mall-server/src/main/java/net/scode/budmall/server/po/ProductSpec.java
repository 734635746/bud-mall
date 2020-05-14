package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[product_spec]对应实体类
 *
 * @author liuyoubin 2020年05月14日
 */
@Data
@TableName(value = "product_spec")
@ApiModel(value = "表[product_spec]的实体类")
public class ProductSpec {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 规格名称
     */
    @ApiModelProperty(value = "规格名称", dataType = "String")
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