package net.scode.budmall.server.dto.navigation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liuyoubin
 * @since 2020/4/23 - 21:51
 */
@Data
public class CategoryNavigationDto {

    /**
     * 导航标题
     */
    @ApiModelProperty(value = "导航标题", dataType = "String")
    @NotBlank(message = "导航标题不能为空")
    private String title;

    /**
     * 导航图片地址
     */
    @ApiModelProperty(value = "导航图片地址", dataType = "String")
    @NotBlank(message = "请选则导航图片")
    private String image;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id", dataType = "int")
    private int categoryId;


}
