package net.scode.budmall.server.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.po.ProductCategory;
import net.scode.budmall.server.po.ProductInfo;
import net.scode.budmall.server.service.ProductBrandService;
import net.scode.budmall.server.service.ProductCategoryService;
import net.scode.budmall.server.vo.productInfo.ProductInfoListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 基于MyBatis-Plus分页查询结果映射工具类
 *
 * @author liuyoubin
 * @since 2020/4/12 - 11:07
 */
@Slf4j
@Component
public class PageQueryResultMapUtil {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductBrandService productBrandService;

    /**
     * 获取查询结果集的封装对象(通用处理)
     *
     * @param pageResult  分页查询结果
     * @param targetClass 目标转换类(这个参数是指定转换后的数据类型,比如AdminUser转成AdminUserVo,这里就需要AdminUserVo.class)
     * @param <E>         分页查询结果对象类型
     * @param <T>         目标转换类型
     * @return 封装结果的HashMap
     */
    public static <E, T> HashMap<String, Object> getResultMap(Page<E> pageResult, Class<T> targetClass) {

        //转换后的数据列表
        List<T> list = new ArrayList<>();
        //查询结果集的数据列表
        List<E> records = pageResult.getRecords();
        //最终需要返回的结果映射
        HashMap<String, Object> map = new HashMap<>();

        try {
            //遍历原数据,转换成目标数据
            for (E record : records) {
                T target = targetClass.newInstance();
                BeanUtils.copyProperties(record, target);
                list.add(target);
            }
            map.put("records", list);
            map.put("total", pageResult.getTotal());
            map.put("size", pageResult.getSize());
            map.put("pages", pageResult.getPages());
            map.put("current", pageResult.getCurrent());

        } catch (InstantiationException | IllegalAccessException e) {
            log.warn("InstantiationException:{}", e.getMessage());
        }

        return map;
    }

    /**
     * 获取商品信息列表的结果映射
     *
     * @param productInfoPage 分页查询结果
     * @return 结果映射对象
     */
    public HashMap<String, Object> getProductInfoListResultMap(Page<ProductInfo> productInfoPage) {

        //最终需要返回的结果映射
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", productInfoPage.getTotal());
        map.put("size", productInfoPage.getSize());
        map.put("pages", productInfoPage.getPages());
        map.put("current", productInfoPage.getCurrent());
        //获取数据集合
        List<ProductInfo> records = productInfoPage.getRecords();
        //转换后的数据集合
        ArrayList<ProductInfoListVo> productInfoListVos = new ArrayList<>();

        for (ProductInfo record : records) {

            ProductInfoListVo productInfoListVo = new ProductInfoListVo();
            BeanUtils.copyProperties(record, productInfoListVo);
            //处理商品图片，商品图片可能有多张
            String productImg = record.getProductImg();
            if (productImg.indexOf(',') != -1) {
                productImg = productImg.substring(0, productImg.indexOf(','));
            }
            productInfoListVo.setProductImg(productImg);
            //处理价格 (价格/原价)
            String price = record.getPrice() + " / " + record.getOriginPrice();
            productInfoListVo.setPrice(price);
            //处理分类名字
            QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("category_id", record.getCategoryId());
            String categoryName = productCategoryService.getOne(queryWrapper).getCategoryName();
            productInfoListVo.setCategoryName(categoryName);
            //处理品牌名字
            String brandName = productBrandService.getById(record.getBrandId()).getBrandName();
            productInfoListVo.setBrandName(brandName);

            productInfoListVos.add(productInfoListVo);
        }

        map.put("records", productInfoListVos);

        return map;
    }

}
