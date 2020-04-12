package net.scode.budmall.server.query;

import lombok.Data;

/**
 * 商品详情查询对象
 *
 * @author liuyoubin
 * @since 2020/4/12 - 10:40
 */
@Data
public class ProductInfoQuery {

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品介绍
     */
    private String intro;
}
