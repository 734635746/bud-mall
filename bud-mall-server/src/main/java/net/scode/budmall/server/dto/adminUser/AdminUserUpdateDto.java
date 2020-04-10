package net.scode.budmall.server.dto.adminUser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;

/**
 * 管理员更新信息Dto
 *
 * @author liuyoubin
 * @since 2020/4/10 - 20:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class AdminUserUpdateDto extends AdminUserDto {

    /**
     * 自增id
     */
    //更新时触发校验,id不能为默认值0(最小为1)
    @Min(value = 1, message = "Id不能为空！")
    @ApiModelProperty(value = "自增id", dataType = "int", required = true)
    private int id;

    /**
     * 通用状态,2正常,3删除,4禁用
     */
    @ApiModelProperty(value = "通用状态,2正常,3删除,4禁用", dataType = "int", required = true)
    private int dataStatus;

}
