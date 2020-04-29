package net.scode.budmall.server.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.po.ProductBrand;
import net.scode.budmall.server.po.ProductCategory;
import net.scode.budmall.server.po.ProductInfo;
import net.scode.budmall.server.service.ProductBrandService;
import net.scode.budmall.server.service.ProductCategoryService;
import net.scode.budmall.server.vo.webVo.productInfo.ProductInfoListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //获取查询的商品数据集合
        List<ProductInfo> records = productInfoPage.getRecords();
        //转换后的商品数据集合
        ArrayList<ProductInfoListVo> productInfoListVos = new ArrayList<>();
        //商品数据集合分类Id列表
        List<Integer> categoryIdList = new ArrayList<>();
        //商品数据集合分类Id列表
        List<Integer> brandIdList = new ArrayList<>();
        //商品分类集合 商品Id-->商品所属分类名字
        Map<Integer, String> categoryMap = new HashMap<>();
        //商品品牌集合 商品Id-->商品所属品牌名字
        Map<Integer, String> brandMap = new HashMap<>();

        //构建商品数据的分类id列表和品牌id列表
        for (ProductInfo record : records) {
            categoryIdList.add(record.getCategoryId());
            brandIdList.add(record.getBrandId());
        }

        //查询商品数据的分类名字并保存到Map中
        QueryWrapper<ProductCategory> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.select("category_id", "category_name");
        categoryQueryWrapper.in("category_id", categoryIdList);
        //查询
        List<ProductCategory> categoryList = productCategoryService.list(categoryQueryWrapper);
        for (ProductCategory category : categoryList) {
            System.out.println(category.getCategoryName());
            categoryMap.put(category.getCategoryId(), category.getCategoryName());
        }

        //查询商品数据的品牌名字并保存到Map中
        QueryWrapper<ProductBrand> brandQueryWrapper = new QueryWrapper<>();
        brandQueryWrapper.select("id", "brand_name");
        brandQueryWrapper.in("id", brandIdList);
        //查询
        List<ProductBrand> brandList = productBrandService.list(brandQueryWrapper);
        for (ProductBrand brand : brandList) {
            brandMap.put(brand.getId(), brand.getBrandName());
        }


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
            productInfoListVo.setCategoryName(categoryMap.get(record.getCategoryId()));
            //处理品牌名字
            productInfoListVo.setBrandName(brandMap.get(record.getBrandId()));

            productInfoListVos.add(productInfoListVo);
        }

        map.put("records", productInfoListVos);

        return map;
    }

}
