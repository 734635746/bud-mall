package net.scode.budmall.server.dto.adminUser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Pattern;

/**
 * 管理员信息Dto
 *
 * @author liuyoubin
 * @since 2020/4/10 - 20:26
 */
@Data
@Accessors(chain = true)
public class AdminUserDto {

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号", dataType = "String", required = true)
    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$", message = "账号只能由字母、数字构成,最少4位最高20位！")
    private String account;

    /**
     * 登陆密码
     */
    @ApiModelProperty(value = "登陆密码", dataType = "String", required = true)
    @Pattern(regexp = "^[A-Za-z0-9$@#%^&]{6,20}$", message = "密码只能由字母、数字、$、@、#、%、^、&构成,最少6位最高20位！")
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
    @ApiModelProperty(value = "角色id", dataType = "int", required = true)
    private int roleId;

}
