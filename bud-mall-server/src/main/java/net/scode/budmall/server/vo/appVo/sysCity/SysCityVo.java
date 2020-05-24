package net.scode.budmall.server.vo.appVo.sysCity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author liuyoubin
 * @since 2020/5/24 - 20:09
 */
@Data
public class SysCityVo {

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
     * 下级地区数据列表
     */
    @ApiModelProperty(value = "下级地区数据列表", dataType = "List")
    private List<SysCityVo> children;

}
