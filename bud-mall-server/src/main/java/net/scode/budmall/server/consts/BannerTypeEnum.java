package net.scode.budmall.server.consts;

/**
 * 横幅类型枚举
 *
 * @author liuyoubin
 * @since 2020/4/22 - 23:30
 */
public enum BannerTypeEnum {

    /**
     * 商品横幅类型
     */
    Product(0),
    /**
     * 外链横幅类型
     */
    OuterChain(1);

    int type;

    BannerTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

}
