package net.scode.budmall.server.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.scode.commons.core.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收货地址管理前台接口
 *
 * @author liuyoubin
 * @since 2020/4/18 - 15:40
 */
@Slf4j
@Api(tags = {"收货地址管理前台接口"})
@RestController
@RequestMapping("/api/delivery/address")
public class DeliveryAddressController {

    @ApiOperation(value = "添加收货地址")
    @PostMapping
    public R saveDeliveryAddress() {
        return null;
    }

}
