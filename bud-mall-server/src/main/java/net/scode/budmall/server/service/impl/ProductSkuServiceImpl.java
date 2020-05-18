package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.ProductSkuDao;
import net.scode.budmall.server.po.ProductSku;
import net.scode.budmall.server.service.ProductSkuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductSku对应service实现
 *
 * @author liuyoubin 2020年04月15日
 */
@Service
public class ProductSkuServiceImpl extends ServiceImpl<ProductSkuDao, ProductSku> implements ProductSkuService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSkuList(int productId, List<ProductSku> skuList) {

        int size = skuList.size();

        if (size != 0) {
            //保存商品sku对象
            ArrayList<ProductSku> productSkuList = new ArrayList<>();

            for (ProductSku productSku : skuList) {

                //设置商品id
                productSku.setProductId(productId);
                productSkuList.add(productSku);
            }
            //保存到数据库
            saveBatch(productSkuList, size);
        }

    }
}