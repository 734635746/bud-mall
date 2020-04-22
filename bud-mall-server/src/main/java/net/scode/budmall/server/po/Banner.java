package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[banner]对应实体类
 *
 * @author liuyoubin 2020年04月22日
 */
@Data
@TableName(value = "banner")
@ApiModel(value = "表[banner]的实体类")
public class Banner {

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

    /**
     * 横幅类型 0商品 1外链
     */
    @ApiModelProperty(value = "横幅类型", dataType = "int")
    private int type;

    /**
     * 横幅位置,1第一处横幅 2第二处横幅
     */
    @ApiModelProperty(value = "横幅位置", dataType = "int")
    private int position;

}