package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Pattern;

/**
 * 表[admin_user]对应实体类
 * 
 * @author liuyoubin 2020年04月06日 
 */
@Data
@Accessors(chain = true)
@TableName(value = "admin_user")
@ApiModel(value = "表[admin_user]的实体类")
public class AdminUser {


    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号", dataType = "String")
    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$",message = "账号只能由字母、数字构成,最少4位最高20位！")
    private String account;

    /**
     * 登陆密码
     */
    @ApiModelProperty(value = "登陆密码", dataType = "String")
    @Pattern(regexp = "^[A-Za-z0-9$@#%^&]{4,20}$",message = "密码只能由字母、数字、$、@、#、%、^、&构成,最少4位最高20位！")
    private String loginPwd;

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
     * 角色id
     */
    @ApiModelProperty(value = "角色id", dataType = "int")
    private int roleId;

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