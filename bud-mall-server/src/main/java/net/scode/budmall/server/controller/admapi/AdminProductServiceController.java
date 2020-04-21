package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.po.ProductService;
import net.scode.budmall.server.service.ProductServiceService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台商品服务管理接口
 *
 * @author liuyoubin
 * @since 2020/4/15 - 20:01
 */
@Slf4j
@Api(tags = {"后台商品服务管理接口"})
@RestController
@RequestMapping("/admapi/product/service")
public class AdminProductServiceController {

    @Autowired
    private ProductServiceService productServiceService;

    @ApiOperation(value = "获取商品服务列表")
    @GetMapping("/list")
    public R list() {
        List<ProductService> list = productServiceService.list();
        return R.data(list);
    }

}
