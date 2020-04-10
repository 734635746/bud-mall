package net.scode.budmall.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Pattern;

/**
 * 管理员登陆Dto
 *
 * @author liuyoubin
 * @since 2020/4/10 - 17:05
 */
@Data
@Accessors(chain = true)
public class AdminUserLoginDto {

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号", dataType = "String")
    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$", message = "账号只能由字母、数字构成,最少4位最高20位！")
    private String account;

    /**
     * 登陆密码
     */
    @ApiModelProperty(value = "登陆密码", dataType = "String")
    @Pattern(regexp = "^[A-Za-z0-9$@#%^&]{4,20}$", message = "密码只能由字母、数字、$、@、#、%、^、&构成,最少4位最高20位！")
    private String loginPwd;

}
