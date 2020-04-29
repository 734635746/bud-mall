package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.ProductBrandDao;
import net.scode.budmall.server.po.ProductBrand;
import net.scode.budmall.server.service.ProductBrandService;
import net.scode.budmall.server.vo.webVo.productBrand.ProductBrandOptionVo;
import net.scode.commons.constant.DataStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductBrand对应service实现
 *
 * @author liuyoubin 2020年04月06日
 */
@Service
public class ProductBrandServiceImpl extends ServiceImpl<ProductBrandDao, ProductBrand> implements ProductBrandService {

    @Override
    public List<ProductBrandOptionVo> listProductBrandOption() {
        //构造查询对象
        QueryWrapper<ProductBrand> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("data_status", DataStatus.NORMAL.getValue());
        //查询
        List<ProductBrand> productBrands = baseMapper.selectList(queryWrapper);
        //结果列表
        ArrayList<ProductBrandOptionVo> productBrandOptionVos = new ArrayList<>();

        for (ProductBrand productBrand : productBrands) {
            ProductBrandOptionVo productBrandOptionVo = new ProductBrandOptionVo();
            BeanUtils.copyProperties(productBrand, productBrandOptionVo);
            productBrandOptionVos.add(productBrandOptionVo);
        }

        return productBrandOptionVos;
    }
}