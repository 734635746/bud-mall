package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[user_info]对应实体类
 *
 * @author liuyoubin 2020年04月06日
 */
@Data
@TableName(value = "user_info")
@ApiModel(value = "表[user_info]的实体类")
public class UserInfo {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 头像图片url地址
     */
    @ApiModelProperty(value = "头像图片url地址", dataType = "String")
    private String avatar;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", dataType = "String")
    private String nickname;

    /**
     * 性别 0:保密 1:男 2:女
     */
    @ApiModelProperty(value = "性别 0:保密 1:男 2:女", dataType = "int")
    private int gender;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日", dataType = "java.util.Date")
    private java.util.Date birthday;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", dataType = "String")
    private String mobile;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", dataType = "String")
    private String email;

    /**
     * 登陆密码
     */
    @ApiModelProperty(value = "登陆密码", dataType = "String")
    private String password;

    /**
     * 通用状态,2正常,3删除,4禁用
     */
    @ApiModelProperty(value = "通用状态,2正常,3删除,4禁用", dataType = "int")
    private int dataStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", dataType = "java.util.Date")
    private java.util.Date createTime;

}