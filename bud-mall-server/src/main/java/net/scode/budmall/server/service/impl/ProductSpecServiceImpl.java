package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.ProductSpecDao;
import net.scode.budmall.server.dto.productSpec.ProductSpecDto;
import net.scode.budmall.server.po.ProductSpec;
import net.scode.budmall.server.po.ProductSpecValue;
import net.scode.budmall.server.service.ProductSpecService;
import net.scode.budmall.server.service.ProductSpecValueService;
import net.scode.budmall.server.vo.webVo.productSpec.ProductSpecItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ProductSpec对应service实现
 *
 * @author liuyoubin 2020年05月14日
 */
@Service
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecDao, ProductSpec> implements ProductSpecService {

    @Autowired
    private ProductSpecValueService productSpecValueService;

    @Override
    public boolean saveProductSpec(ProductSpecDto productSpecDto) {

        return updateProductSpec(0, productSpecDto);
    }

    @Override
    public boolean updateProductSpec(Integer id, ProductSpecDto productSpecDto) {

        ProductSpec productSpec = new ProductSpec();
        BeanUtils.copyProperties(productSpecDto, productSpec);

        if (id == 0) {//添加
            return save(productSpec);
        } else {
            productSpec.setId(id);
            return updateById(productSpec);
        }

    }

    @Override
    public List<ProductSpecItemVo> listProductSpecAndValue() {

        List<ProductSpecItemVo> list = baseMapper.listProductSpecItem();

        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeProductSpec(Integer id) {
        //删除商品规格
        int i = baseMapper.deleteById(id);

        //删除规格所有的属性值
        if (i == 1) {
            QueryWrapper<ProductSpecValue> wrapper = new QueryWrapper<>();
            wrapper.eq("spec_id", id);
            productSpecValueService.remove(wrapper);
        }

        return true;
    }


}