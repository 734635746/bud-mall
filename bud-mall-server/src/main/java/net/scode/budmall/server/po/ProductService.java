package net.scode.budmall.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表[product_service]对应实体类
 *
 * @author liuyoubin 2020年04月15日
 */
@Data
@TableName(value = "product_service")
@ApiModel(value = "表[product_service]的实体类")
public class ProductService {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id", dataType = "int")
    private long id;

    /**
     * 服务名称
     */
    @ApiModelProperty(value = "服务名称", dataType = "String")
    private String serviceName;

    /**
     * 服务描述
     */
    @ApiModelProperty(value = "服务描述", dataType = "String")
    private String description;

    /**
     * logo
     */
    @ApiModelProperty(value = "logo", dataType = "String")
    private String logo;

}