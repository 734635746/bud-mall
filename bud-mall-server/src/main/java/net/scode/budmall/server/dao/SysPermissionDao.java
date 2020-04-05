package net.scode.budmall.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.scode.budmall.server.po.SysPermission;
import org.apache.ibatis.annotations.Param;

/**
 * 表[sys_permission]对应实体类
 *
 * @author tanghuang 2020年02月22日
 */
public interface SysPermissionDao extends BaseMapper<SysPermission> {

    /**
     * 分页搜索
     *
     * @param keywords
     * @param page
     * @return
     */
    Page<SysPermission> pageSearch(@Param("keywords") String keywords, @Param("pg") Page page);

}