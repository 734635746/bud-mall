package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.SysRoleDao;
import net.scode.budmall.server.po.SysRole;
import net.scode.budmall.server.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * SysRole对应service实现
 *
 * @author tanghuang 2020年02月23日
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    @Override
    public Page<SysRole> pageSearch(String keywords, Page page) {
        return this.getBaseMapper().pageSearch(keywords, page);
    }

}