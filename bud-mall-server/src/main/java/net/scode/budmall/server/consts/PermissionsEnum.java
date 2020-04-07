package net.scode.budmall.server.consts;

/**
 * 权限枚举
 * @author liuyoubin
 * @since 2020/4/7 - 0:14
 */
public enum  PermissionsEnum {

    /**
     * 用户删除权限
     */
    ADMIN_DELETE("admin:delete");


    /**
     * 权限名
     */
    String permit;

    PermissionsEnum(String permit){
        this.permit = permit;
    }

    public String getPermit(){
        return permit;
    }

}
