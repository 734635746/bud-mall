package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.consts.ProductConsts;
import net.scode.budmall.server.dao.ProductInfoDao;
import net.scode.budmall.server.dto.product.ProductInfoDto;
import net.scode.budmall.server.po.ProductInfo;
import net.scode.budmall.server.query.ProductInfoQuery;
import net.scode.budmall.server.service.ProductInfoService;
import net.scode.budmall.server.util.PageQueryResultMapUtil;
import net.scode.budmall.server.vo.ProductInfoVo;
import net.scode.commons.constant.DataStatus;
import net.scode.commons.exception.ScodeRuntimeException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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

    @Override
    public boolean updateProductInfoById(Integer id, ProductInfoDto productInfoDto) {

        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productInfoDto, productInfo);
        //设置data_status
        productInfo.setDataStatus(DataStatus.NORMAL.getValue());
        //设置默认图片
        if (StringUtils.isBlank(productInfoDto.getProductImg())) {
            productInfo.setProductImg(ProductConsts.DEFAULT_PRODUCT_IMG);
        }
        //设置id
        productInfo.setId(id);

        return updateById(productInfo);
    }

    @Override
    public HashMap<String, Object> pageQueryProductInfos(Long page, Long limit, ProductInfoQuery productInfoQuery) {

        //判断分页参数和合法性
        if (page <= 0 || limit <= 0) {
            throw new ScodeRuntimeException("分页参数不合法！");
        }
        //构造分页查询参数对象
        Page<ProductInfo> productInfoPage = new Page<>(page, limit);
        //获取查询参数
        String productName = productInfoQuery.getProductName();
        String intro = productInfoQuery.getIntro();
        //构造查询参数对象
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(productName)) {
            queryWrapper.like("product_name", productName);
        }
        if (StringUtils.isNotBlank(intro)) {
            queryWrapper.like("intro", intro);
        }
        //排除处于删除状态的商品
        queryWrapper.ne("data_status", DataStatus.DEL.getValue());
        //排序
        queryWrapper.orderByDesc("sort");

        //查询
        baseMapper.selectPage(productInfoPage, queryWrapper);

        return PageQueryResultMapUtil.getResultMap(productInfoPage, ProductInfoVo.class);
    }


    @Override
    public ProductInfoVo getProductInfoById(Integer id) {

        ProductInfo productInfo = getById(id);
        if (productInfo == null || productInfo.getDataStatus() == DataStatus.DEL.getValue()) {
            throw new ScodeRuntimeException("商品不存在！");
        }

        ProductInfoVo productInfoVo = new ProductInfoVo();
        BeanUtils.copyProperties(productInfo, productInfoVo);

        return productInfoVo;
    }
}