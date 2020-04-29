package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.consts.ProductConsts;
import net.scode.budmall.server.dao.ProductInfoDao;
import net.scode.budmall.server.dto.productInfo.ProductInfoDto;
import net.scode.budmall.server.dto.productSku.ProductSkuDto;
import net.scode.budmall.server.po.ProductInfo;
import net.scode.budmall.server.po.ProductSku;
import net.scode.budmall.server.query.ProductInfoQuery;
import net.scode.budmall.server.service.ProductInfoService;
import net.scode.budmall.server.service.ProductSkuService;
import net.scode.budmall.server.util.PageQueryResultMapUtil;
import net.scode.budmall.server.vo.appVo.productInfo.ProductListAppVo;
import net.scode.budmall.server.vo.webVo.productInfo.ProductInfoVo;
import net.scode.commons.constant.DataStatus;
import net.scode.commons.exception.ScodeRuntimeException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ProductInfo对应service实现
 *
 * @author liuyoubin 2020年04月10日
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoDao, ProductInfo> implements ProductInfoService {

    @Autowired
    private ProductSkuService productSkuService;

    @Autowired
    private PageQueryResultMapUtil pageQueryResultMapUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveProductInfo(ProductInfoDto productInfoDto) {

        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productInfoDto, productInfo);

        //设置data_status
        productInfo.setDataStatus(DataStatus.NORMAL.getValue());
        //设置默认商品图片
        if (StringUtils.isBlank(productInfoDto.getProductImg())) {
            productInfo.setProductImg(ProductConsts.DEFAULT_PRODUCT_IMG);
        }

        //保存商品详情数据
        baseMapper.insertProductInfo(productInfo);
        //保存Sku数据
        productSkuService.saveSkuList(productInfo.getId(), productInfoDto.getSkuList());

        return true;
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
    @Transactional(rollbackFor = Exception.class)
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
        //修改商品详情信息
        updateById(productInfo);

        //处理SKU信息
        //查询商品下所有之前SKU的id
        QueryWrapper<ProductSku> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", id);
        queryWrapper.select("id");
        List<ProductSku> list = productSkuService.list(queryWrapper);
        //存放原先SKU的id
        List<Integer> oldSkuListId = new ArrayList<>();
        list.forEach(arg -> {
            oldSkuListId.add(arg.getId());
        });
        //遍历获取前端传过来的SKU信息
        List<ProductSkuDto> skuList = productInfoDto.getSkuList();
        for (ProductSkuDto productSkuDto : skuList) {
            ProductSku productSku = new ProductSku();
            BeanUtils.copyProperties(productSkuDto, productSku);
            if (productSku.getId() != 0) {//旧的的SKU
                productSkuService.updateById(productSku);
                //移除SKU的id代表不需要删除
                oldSkuListId.remove(new Integer(productSku.getId()));
            } else {
                productSku.setProductId(id);
                productSkuService.save(productSku);
            }
        }
        //剩下的SKU id代表需要删除的
        for (Integer oId : oldSkuListId) {
            productSkuService.removeById(oId);
        }

        return true;
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
        //构造查询参数对象
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(productName)) {
            queryWrapper.like("product_name", productName);
        }
        //排除处于删除状态的商品
        queryWrapper.ne("data_status", DataStatus.DEL.getValue());
        //排序
        queryWrapper.orderByDesc("sort");
        //查询
        baseMapper.selectPage(productInfoPage, queryWrapper);

        return pageQueryResultMapUtil.getProductInfoListResultMap(productInfoPage);
    }


    @Override
    public ProductInfoVo getProductInfoById(Integer id) {
        //查询商品详情信息
        ProductInfo productInfo = getById(id);
        if (productInfo == null || productInfo.getDataStatus() == DataStatus.DEL.getValue()) {
            throw new ScodeRuntimeException("商品不存在！");
        }

        ProductInfoVo productInfoVo = new ProductInfoVo();
        BeanUtils.copyProperties(productInfo, productInfoVo);

        //处理商品SKU信息
        QueryWrapper<ProductSku> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", id);
        //查询商品对应的SKU信息列表
        List<ProductSku> productSkuList = productSkuService.list(queryWrapper);
        productInfoVo.setSkuList(productSkuList);

        return productInfoVo;
    }

    @Override
    public List<ProductListAppVo> listAppProductInfo() {

        //构造查询参数对象
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("sort");
        queryWrapper.ne("data_status", DataStatus.DEL);
        queryWrapper.select("id", "product_name", "product_img", "price");
        List<ProductInfo> productInfos = list(queryWrapper);

        return productInfos.stream().map(productInfo -> {
            ProductListAppVo productListAppVo = new ProductListAppVo();
            BeanUtils.copyProperties(productInfo, productListAppVo);
            return productListAppVo;
        }).collect(Collectors.toList());
    }


}