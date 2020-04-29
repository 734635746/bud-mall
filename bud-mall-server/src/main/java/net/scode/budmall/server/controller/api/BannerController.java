package net.scode.budmall.server.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.service.BannerService;
import net.scode.budmall.server.vo.appVo.banner.BannerAppVo;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台横幅调用接口
 *
 * @author liuyoubin
 * @since 2020/4/22 - 21:45
 */
@Slf4j
@Api(tags = {"前台横幅调用接口"})
@RestController
@RequestMapping("/api/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation(value = "获取指定位置的横幅列表")
    @GetMapping("/list")
    public R listBannerByPosition(
            @ApiParam(name = "position", value = "横幅位置,1第一处横幅 2第二处横幅", required = true)
            @RequestParam(value = "position") Integer position) {

        List<BannerAppVo> list = bannerService.listBannerVoByPosition(position);

        return R.data(list);

    }

}
