package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.consts.ProductConsts;
import net.scode.budmall.server.dao.ProductInfoDao;
import net.scode.budmall.server.dto.product.ProductInfoDto;
import net.scode.budmall.server.po.ProductInfo;
import net.scode.budmall.server.service.ProductInfoService;
import net.scode.commons.constant.DataStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * ProductInfo对应service实现
 *
 * @author liuyoubin 2020年04月10日
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoDao, ProductInfo> implements ProductInfoService {

    @Override
    public boolean addProductInfo(ProductInfoDto productInfoDto) {

        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productInfoDto, productInfo);

        //设置data_status
        productInfo.setDataStatus(DataStatus.NORMAL.getValue());
        //设置默认图片
        if (StringUtils.isBlank(productInfoDto.getProductImg())) {
            productInfo.setProductImg(ProductConsts.DEFAULT_PRODUCT_IMG);
        }

        return save(productInfo);
    }

    @Override
    public boolean deleteProductInfoById(Integer id) {

        UpdateWrapper<ProductInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.ne("data_status", DataStatus.DEL.getValue());
        updateWrapper.set("data_status", DataStatus.DEL.getValue());
        updateWrapper.eq("id", id);

        return update(updateWrapper);

    }
}