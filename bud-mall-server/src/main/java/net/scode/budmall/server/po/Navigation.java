package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[navigation]对应实体类
 *
 * @author liuyoubin 2020年04月23日
 */
@Data
@TableName(value = "navigation")
@ApiModel(value = "表[navigation]的实体类")
public class Navigation {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

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

    /**
     * 导航类型 0分类导航
     */
    @ApiModelProperty(value = "导航类型", dataType = "int")
    private int type;


}