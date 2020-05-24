package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.SysCityDao;
import net.scode.budmall.server.po.SysCity;
import net.scode.budmall.server.service.SysCityService;
import net.scode.budmall.server.vo.appVo.sysCity.SysCityVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SysCity对应service实现
 *
 * @author liuyoubin 2020年04月18日
 */
@Service
public class SysCityServiceImpl extends ServiceImpl<SysCityDao, SysCity> implements SysCityService {

    @Override
    public List<SysCityVo> listSysCityVo() {
        return baseMapper.listSysCityVoByParentId(1);
    }
}