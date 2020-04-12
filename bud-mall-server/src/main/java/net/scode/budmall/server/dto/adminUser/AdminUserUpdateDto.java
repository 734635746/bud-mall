package net.scode.budmall.server.dto.adminUser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * 管理员更新信息Dto
 *
 * @author liuyoubin
 * @since 2020/4/10 - 20:42
 */

@Data
@Accessors(chain = true)
public class AdminUserUpdateDto {

    /**
     * 自增id
     */
    //更新时触发校验,id不能为默认值0(最小为1)
    @Min(value = 1, message = "Id不能为空！")
    @ApiModelProperty(value = "自增id", dataType = "int", required = true)
    private int id;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号", dataType = "String", required = true)
    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$", message = "账号只能由字母、数字构成,最少4位最高20位！")
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
    @ApiModelProperty(value = "角色id", dataType = "int", required = true)
    private int roleId;

    /**
     * 通用状态,2正常,3删除,4禁用
     */
    @ApiModelProperty(value = "通用状态,2正常,3删除,4禁用", dataType = "int", required = true)
    private int dataStatus;

}
