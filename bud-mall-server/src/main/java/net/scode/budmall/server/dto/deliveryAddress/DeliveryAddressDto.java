package net.scode.budmall.server.dto.deliveryAddress;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 收货地址Dto
 *
 * @author liuyoubin
 * @since 2020/4/18 - 20:33
 */
@Data
public class DeliveryAddressDto {

    /**
     * 收件人姓名
     */
    @ApiModelProperty(value = "收件人姓名", dataType = "String", required = true)
    @NotBlank(message = "收件人姓名不能为空")
    private String contactsName;

    /**
     * 收件人手机号
     */
    @ApiModelProperty(value = "收件人手机号", dataType = "String", required = true)
    @Pattern(regexp = "^(13[0-9]|14[0|5-7|9]|15[0-3|5 -9]|16[2|5-7]|17[0-3|5-8]|18[0-9]|19[1|8-9])\\d{8}$", message = "手机号不合法")
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
    @ApiModelProperty(value = "详细地址", dataType = "String", required = true)
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
