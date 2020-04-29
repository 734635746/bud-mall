package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.app.UserAppContext;
import net.scode.budmall.server.dao.DeliveryAddressDao;
import net.scode.budmall.server.dto.deliveryAddress.DeliveryAddressDto;
import net.scode.budmall.server.po.DeliveryAddress;
import net.scode.budmall.server.po.SysCity;
import net.scode.budmall.server.service.DeliveryAddressService;
import net.scode.budmall.server.service.SysCityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DeliveryAddress对应service实现
 *
 * @author liuyoubin 2020年04月18日
 */
@Service
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryAddressDao, DeliveryAddress> implements DeliveryAddressService {

    @Autowired
    private SysCityService sysCityService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveDeliveryAddress(DeliveryAddressDto deliveryAddressDto) {

        //添加新的收货地址
        return updateDeliveryAddress(0, deliveryAddressDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateDeliveryAddress(Integer id, DeliveryAddressDto deliveryAddressDto) {

        DeliveryAddress deliveryAddress = new DeliveryAddress();
        BeanUtils.copyProperties(deliveryAddressDto, deliveryAddress);

        //获取用户id
        int userId = UserAppContext.getUserId();
        //设置用户id
        deliveryAddress.setUserId(userId);

        //获取省市县三级id
        int provinceId = deliveryAddressDto.getProvinceId();
        int cityId = deliveryAddressDto.getCityId();
        int districtId = deliveryAddressDto.getDistrictId();
        //构造查询参数查询并校验
        QueryWrapper<SysCity> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(i -> i.eq("id", provinceId).eq("parent_id", 1));
        queryWrapper.or(i -> i.eq("id", cityId).eq("parent_id", provinceId));
        queryWrapper.or(i -> i.eq("id", districtId).eq("parent_id", cityId));
        List<SysCity> sysCities = sysCityService.list(queryWrapper);
        //设置地区名字
        for (SysCity city : sysCities) {
            int cId = city.getId();
            String cityName = city.getName();
            if (cId == provinceId) {
                deliveryAddress.setProvince(cityName);
            }
            if (cId == cityId) {
                deliveryAddress.setCity(cityName);
            }
            if (cId == districtId) {
                deliveryAddress.setDistrict(cityName);
            }
        }

        //判断新添加的收货地址是否设置成默认,如果设置成默认则将该用户的其他收货地址设置成非默认
        if (deliveryAddress.getIsDefault() == 1) {//设置成默认
            UpdateWrapper<DeliveryAddress> updateWrapper = new UpdateWrapper<>();
            updateWrapper.set("is_default", 0);
            updateWrapper.ne("id", id);//排除掉当前待修改的数据
            updateWrapper.eq("user_id", userId);
            update(updateWrapper);
        }

        if (id == 0) {//如果地址信息id为0则此操作是插入操作
            return save(deliveryAddress);
        } else {//更新操作
            deliveryAddress.setId(id);
            return updateById(deliveryAddress);
        }

    }
}