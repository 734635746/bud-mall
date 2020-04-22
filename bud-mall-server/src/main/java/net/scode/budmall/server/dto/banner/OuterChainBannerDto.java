package net.scode.budmall.server.dto.banner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 外链横幅信息Dto
 *
 * @author liuyoubin
 * @since 2020/4/22 - 22:29
 */
@Data
public class OuterChainBannerDto {

    /**
     * 横幅标题
     */
    @ApiModelProperty(value = "横幅标题", dataType = "String")
    private String title;

    /**
     * 横幅图片地址
     */
    @ApiModelProperty(value = "横幅图片地址", dataType = "String", required = true)
    @NotBlank(message = "横幅图片地址不能为空")
    private String image;

    /**
     * 外链地址
     */
    @ApiModelProperty(value = "外链地址", dataType = "String", required = true)
    @NotBlank(message = "外链地址不能为空")
    private String outerChain;


    /**
     * 横幅位置,1第一处横幅 2第二处横幅
     */
    @ApiModelProperty(value = "横幅位置", dataType = "int", required = true)
    @Min(value = 1, message = "未指定横幅的位置")
    private int position;

}
