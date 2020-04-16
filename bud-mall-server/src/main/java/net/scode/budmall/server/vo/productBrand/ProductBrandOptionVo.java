package net.scode.budmall.server.vo.productBrand;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品品牌选项Vo对象
 *
 * @author liuyoubin
 * @since 2020/4/16 - 0:28
 */
@Data
public class ProductBrandOptionVo {

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

}
