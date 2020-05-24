package net.scode.budmall.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.scode.budmall.server.po.SysCity;
import net.scode.budmall.server.vo.appVo.sysCity.SysCityVo;

import java.util.List;

/**
 * 表[sys_city]对应实体类
 *
 * @author liuyoubin 2020年04月18日
 */
public interface SysCityDao extends BaseMapper<SysCity> {

    /**
     * 根据ParentId获取系统地址数据Vo对象嵌套列表
     *
     * @param i 父id
     * @return 系统地址数据Vo对象嵌套列表
     */
    List<SysCityVo> listSysCityVoByParentId(int i);
}