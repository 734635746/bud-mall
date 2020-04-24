package net.scode.budmall.server.vo.navigation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liuyoubin
 * @since 2020/4/23 - 20:29
 */
@Data
public class NavigationVo {

    /**
     * 导航标题
     */
    @ApiModelProperty(value = "导航标题", dataType = "String")
    private String title;

    /**
     * 导航图片地址
     */
    @ApiModelProperty(value = "导航图片地址", dataType = "String")
    private String image;

    /**
     * 导航跳转地址
     */
    @ApiModelProperty(value = "导航跳转地址", dataType = "String")
    private String content;

}
