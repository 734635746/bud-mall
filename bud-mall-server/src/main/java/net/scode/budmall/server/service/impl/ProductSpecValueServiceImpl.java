package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.ProductSpecValueDao;
import net.scode.budmall.server.dto.productSpec.ProductSpecValueDto;
import net.scode.budmall.server.po.ProductSpecValue;
import net.scode.budmall.server.service.ProductSpecValueService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * ProductSpecValue对应service实现
 *
 * @author liuyoubin 2020年05月14日
 */
@Service
public class ProductSpecValueServiceImpl extends ServiceImpl<ProductSpecValueDao, ProductSpecValue> implements ProductSpecValueService {

    @Override
    public boolean saveProductSpecValue(ProductSpecValueDto productSpecValueDto) {


        return updateProductSpecValue(0, productSpecValueDto);
    }

    @Override
    public boolean updateProductSpecValue(Integer id, ProductSpecValueDto productSpecValueDto) {

        ProductSpecValue productSpecValue = new ProductSpecValue();
        BeanUtils.copyProperties(productSpecValueDto, productSpecValue);

        if (id == 0) {//添加
            return save(productSpecValue);
        } else {//修改
            productSpecValue.setId(id);
            return updateById(productSpecValue);
        }

    }
}