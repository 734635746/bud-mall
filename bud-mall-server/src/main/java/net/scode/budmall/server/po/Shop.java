package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[shop]对应实体类
 *
 * @author liuyoubin 2020年04月15日
 */
@Data
@TableName(value = "shop")
@ApiModel(value = "表[shop]的实体类")
public class Shop {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 店铺名称
     */
    @ApiModelProperty(value = "店铺名称", dataType = "String")
    private String shopName;

    /**
     * 店铺商品数量
     */
    @ApiModelProperty(value = "店铺商品数量", dataType = "int")
    private int productNum;

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