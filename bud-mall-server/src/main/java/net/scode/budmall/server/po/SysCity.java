package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[sys_city]对应实体类
 *
 * @author liuyoubin 2020年04月18日
 */
@Data
@TableName(value = "sys_city")
@ApiModel(value = "表[sys_city]的实体类")
public class SysCity {

    /**
     * 非自增id
     */
    @ApiModelProperty(value = "非自增id", dataType = "int")
    private int id;

    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级id", dataType = "int")
    private int parentId;

    /**
     * 分类地区名
     */
    @ApiModelProperty(value = "分类地区名", dataType = "String")
    private String name;

    /**
     * 拼音
     */
    @ApiModelProperty(value = "拼音", dataType = "String")
    private String spell;

    /**
     * 排序权重
     */
    @ApiModelProperty(value = "排序权重", dataType = "int")
    private int sort;

    /**
     * 通用状态,2正常,3删除
     */
    @ApiModelProperty(value = "通用状态,2正常,3删除", dataType = "int")
    private int dataStatus;

}