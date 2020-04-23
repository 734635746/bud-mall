package net.scode.budmall.server.vo.banner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liuyoubin
 * @since 2020/4/22 - 22:15
 */
@Data
public class BannerVo {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 横幅标题
     */
    @ApiModelProperty(value = "横幅标题", dataType = "String")
    private String title;

    /**
     * 横幅图片地址
     */
    @ApiModelProperty(value = "横幅图片地址", dataType = "String")
    private String image;

    /**
     * 横幅信息 具体为商品地址还是外链地址
     */
    @ApiModelProperty(value = "横幅信息", dataType = "String")
    private String content;
}
