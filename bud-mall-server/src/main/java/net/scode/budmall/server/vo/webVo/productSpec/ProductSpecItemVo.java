package net.scode.budmall.server.vo.webVo.productSpec;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.scode.budmall.server.po.ProductSpecValue;

import java.util.List;

/**
 * 商品规格列表
 *
 * @author liuyoubin
 * @since 2020/5/14 - 21:07
 */
@Data
public class ProductSpecItemVo {

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

    /**
     * 该规格下所有的值列表
     */
    @ApiModelProperty(value = "规格值列表", dataType = "List")
    private List<ProductSpecValue> values;


}
