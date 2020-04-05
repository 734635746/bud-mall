package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.SysPermissionDao;
import net.scode.budmall.server.po.SysPermission;
import net.scode.budmall.server.service.SysPermissionService;
import org.springframework.stereotype.Service;

/**
 * SysPermission对应Service实现
 *
 * @author tanghuang 2020年02月23日
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao, SysPermission> implements SysPermissionService {

    @Override
    public Page<SysPermission> pageSearch(String keywords, Page page) {
        return this.getBaseMapper().pageSearch(keywords, page);
    }

}
