package net.scode.budmall.server.controller.api;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.dto.deliveryAddress.DeliveryAddressDto;
import net.scode.budmall.server.po.DeliveryAddress;
import net.scode.budmall.server.service.DeliveryAddressService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 前台收货地址调用接口
 *
 * @author liuyoubin
 * @since 2020/4/18 - 15:40
 */
@Slf4j
@Api(tags = {"前台收货地址调用接口"})
@RestController
@RequestMapping("/api/delivery/address")
public class DeliveryAddressController {

    @Autowired
    private DeliveryAddressService deliveryAddressService;


    @ApiOperation(value = "添加收货地址")
    @PostMapping
    public R saveDeliveryAddress(
            @ApiParam(name = "adminUser", value = "收货地址信息", required = true)
            @RequestBody @Validated DeliveryAddressDto deliveryAddressDto) {


        boolean isSuccess = deliveryAddressService.saveDeliveryAddress(deliveryAddressDto);

        return isSuccess ? R.ok() : R.error("【添加收货地址】操作失败");

    }

    @ApiOperation(value = "根据收货地址id删除收货地址")
    @DeleteMapping("/{id}")
    public R removeDeliveryAddress(
            @ApiParam(name = "id", value = "收货地址id", required = true)
            @PathVariable(value = "id") Integer id) {

        boolean isSuccess = deliveryAddressService.removeById(id);

        return isSuccess ? R.ok() : R.error("【删除收货地址】操作失败");
    }

    @ApiOperation(value = "修改收货地址")
    @PutMapping("/{id}")
    public R updateDeliveryAddress(
            @ApiParam(name = "id", value = "收货地址id", required = true)
            @PathVariable(value = "id") @NotNull(message = "收货地址id不能为空") Integer id,
            @ApiParam(name = "adminUser", value = "收货地址信息", required = true)
            @RequestBody @Validated DeliveryAddressDto deliveryAddressDto) {

        boolean isSuccess = deliveryAddressService.updateDeliveryAddress(id, deliveryAddressDto);

        return isSuccess ? R.ok() : R.error("【修改收货地址】操作失败");

    }

    @ApiOperation(value = "修改收货地址的顺序的接口")
    @PutMapping("/sort/{id}")
    public R updateDeliveryAddressSort(
            @ApiParam(name = "id", value = "收货地址id", required = true)
            @PathVariable(value = "id") Integer id,
            @ApiParam(name = "sort", value = "排序权重", required = true)
            @RequestParam(value = "sort") Integer sort) {

        UpdateWrapper<DeliveryAddress> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("sort", sort);
        boolean isSuccess = deliveryAddressService.update(updateWrapper);

        return isSuccess ? R.ok() : R.error("【修改收货地址的顺序】操作失败");
    }
}
