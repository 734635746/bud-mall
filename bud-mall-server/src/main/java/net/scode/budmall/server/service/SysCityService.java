package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.po.SysCity;
import net.scode.budmall.server.vo.appVo.sysCity.SysCityVo;

import java.util.List;

/**
 * SysCity对应Service
 *
 * @author liuyoubin 2020年04月18日
 */
public interface SysCityService extends IService<SysCity> {

    /**
     * 获取系统地址数据Vo对象嵌套列表
     *
     * @return 系统地址数据Vo对象嵌套列表
     */
    List<SysCityVo> listSysCityVo();

}