package net.scode.budmall.server.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

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
public class PageQueryResultMapUtil {

    /**
     * 获取查询结果集的封装对象
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
}
