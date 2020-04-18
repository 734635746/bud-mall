package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[delivery_address]对应实体类
 *
 * @author liuyoubin 2020年04月18日
 */
@Data
@TableName(value = "delivery_address")
@ApiModel(value = "表[delivery_address]的实体类")
public class DeliveryAddress {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 自增id
     */
    @ApiModelProperty(value = "用户id", dataType = "int")
    private int userId;

    /**
     * 收件人姓名
     */
    @ApiModelProperty(value = "收件人姓名", dataType = "String")
    private String contactsName;

    /**
     * 收件人手机号
     */
    @ApiModelProperty(value = "收件人手机号", dataType = "String")
    private String contactPhone;

    /**
     * 省份/地区
     */
    @ApiModelProperty(value = "省份/地区", dataType = "String")
    private String province;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市", dataType = "String")
    private String city;

    /**
     * 区/县
     */
    @ApiModelProperty(value = "区/县", dataType = "String")
    private String district;

    /**
     * 详细地址：如街道、门牌号、小区、楼栋号、单元室等
     */
    @ApiModelProperty(value = "详细地址", dataType = "String")
    private String detailedAddress;

    /**
     * 是否默认 0非默认 1默认
     */
    @ApiModelProperty(value = "是否默认", dataType = "int")
    private int isDefault;

    /**
     * 排序权重
     */
    @ApiModelProperty(value = "排序权重", dataType = "int")
    private int sort;

}