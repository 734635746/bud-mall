package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.deliveryAddress.DeliveryAddressDto;
import net.scode.budmall.server.po.DeliveryAddress;

/**
 * DeliveryAddress对应Service
 *
 * @author liuyoubin 2020年04月18日
 */
public interface DeliveryAddressService extends IService<DeliveryAddress> {

    /**
     * 添加收货地址信息
     *
     * @param deliveryAddressDto 收货地址Dto
     * @return 是否添加成功
     */
    boolean saveDeliveryAddress(DeliveryAddressDto deliveryAddressDto);

    /**
     * 修改收货地址信息
     *
     * @param id                 收货地址id
     * @param deliveryAddressDto 收货地址Dto
     * @return 是否修改成功
     */
    boolean updateDeliveryAddress(Integer id, DeliveryAddressDto deliveryAddressDto);
}