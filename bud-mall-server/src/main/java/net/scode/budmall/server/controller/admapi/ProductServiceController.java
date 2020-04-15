package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.service.ProductServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台商品服务管理接口
 *
 * @author liuyoubin
 * @since 2020/4/15 - 20:01
 */
@Slf4j
@Api(tags = {"商品服务管理接口"})
@RestController
@RequestMapping("/admapi/product/service")
public class ProductServiceController {

    @Autowired
    private ProductServiceService productServiceService;

//    @ApiOperation(value = "获取商品服务列表")
//    @GetMapping("/list")
//    public R list() {
//
//        productServiceService.listProductService();
//    }

}
