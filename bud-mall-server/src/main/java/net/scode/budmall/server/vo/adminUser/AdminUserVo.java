package net.scode.budmall.server.vo.adminUser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 返回给前端的管理员信息Vo对象（主要是排除loginPwd字段）
 *
 * @author liuyoubin
 * @since 2020/4/7 - 21:03
 */
@Data
@Accessors(chain = true)
public class AdminUserVo {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private int id;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号", dataType = "String")
    private String account;


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
