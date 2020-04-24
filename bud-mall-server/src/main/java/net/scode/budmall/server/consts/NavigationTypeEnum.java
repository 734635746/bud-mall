package net.scode.budmall.server.consts;

/**
 * @author liuyoubin
 * @since 2020/4/23 - 22:32
 */
public enum NavigationTypeEnum {

    /**
     * 分类导航类型
     */
    Category(0);


    int type;

    NavigationTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

}
