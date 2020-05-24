package net.scode.budmall.server.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.service.SysCityService;
import net.scode.budmall.server.vo.appVo.sysCity.SysCityVo;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台系统地址数据调用接口
 *
 * @author liuyoubin
 * @since 2020/5/24 - 20:07
 */
@Slf4j
@Api(tags = {"前台系统地址数据调用接口"})
@RestController
@RequestMapping("/api/sys/city")
public class SysCityController {

    @Autowired
    private SysCityService sysCityService;

    @ApiOperation(value = "系统地址数据嵌套列表")
    @GetMapping("/list")
    public R listSysCity() {

        List<SysCityVo> list = sysCityService.listSysCityVo();

        return R.data(list);
    }

}
