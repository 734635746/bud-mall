package net.scode.budmall.server.controller.admapi;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.service.SysPermissionService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 管理后台接口
 *
 * @author tanghuang 2020年02月21日
 */
@Slf4j
@Api(tags = {"管理后台接口"})
@RestController
@RequestMapping("/admapi")
public class AdminController {

    @Autowired
    private SysPermissionService sysPermissionService;


    /**
     * 测试接口
     *
     * @return
     */
    @ApiOperation(value = "测试接口")
    @GetMapping("/test")
    public R test() {
        Map map = MapUtil.newHashMap();
        map.put("message", "这是测试的内容");
        return R.ok(map);
    }

    /**
     * 测试数据库接口
     *
     * @return
     */
    @ApiOperation(value = "测试数据库接口")
    @GetMapping("/test_db")
    public R testDb() {
        Page page = new Page();
        return R.data(sysPermissionService.page(page));
    }

}
