package net.scode.budmall.server.vo.appVo.deliveryAddress;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liuyoubin
 * @since 2020/5/23 - 22:07
 */
@Data
public class DeliveryAddressVo {
    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 用户id
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
     * 省份/地区(id)
     */
    @ApiModelProperty(value = "省份/地区", dataType = "String", required = true)
    private int provinceId;

    /**
     * 城市(id)
     */
    @ApiModelProperty(value = "城市", dataType = "String", required = true)
    private int cityId;

    /**
     * 区/县(id)
     */
    @ApiModelProperty(value = "区/县", dataType = "String", required = true)
    private int districtId;

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
