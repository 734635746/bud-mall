package net.scode.budmall.server.dto.adminUser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * 管理员密码修改信息Dto
 *
 * @author liuyoubin
 * @since 2020/4/12 - 22:34
 */
@Data
public class AdminUserPwdDto {

    //@ApiModelProperty(value = "原密码", dataType = "String", required = true)
    //private String oldPassword;

    @ApiModelProperty(value = "新密码", dataType = "String", required = true)
    @Pattern(regexp = "^[A-Za-z0-9$@#%^&]{6,20}$", message = "密码只能由字母、数字、$、@、#、%、^、&构成,最少6位最高20位！")
    private String newPassword;

}
