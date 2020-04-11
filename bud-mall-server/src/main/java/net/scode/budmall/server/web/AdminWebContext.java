package net.scode.budmall.server.web;

import lombok.Data;

/**
 * 存放管理后台web的上下文信息，主要是API接口的公共参数
 *
 * @author tanghuang 2020年02月25日
 */
public class AdminWebContext {

    private static final ThreadLocal<PublicParameter> publicParameterHolder = new
            ThreadLocal<PublicParameter>() {
                @Override
                protected AdminWebContext.PublicParameter initialValue() {
                    return new AdminWebContext.PublicParameter();
                }
            };

    /**
     * 获得公共参数
     *
     * @return
     */
    public static AdminWebContext.PublicParameter getPublicParameter() {
        return publicParameterHolder.get();
    }

    /**
     * 清除
     */
    public static void clear() {
        publicParameterHolder.remove();
    }

    /**
     * 用户IP
     *
     * @return
     */
    public static String getIp() {
        AdminWebContext.PublicParameter p = publicParameterHolder.get();
        return p.getIp();
    }

    /**
     * token
     *
     * @return
     */
    public static String getToken() {
        AdminWebContext.PublicParameter p = publicParameterHolder.get();
        return p.getToken();
    }

    public static int getAdminUserId() {
        AdminWebContext.PublicParameter p = publicParameterHolder.get();
        return p.getAdminUserId();
    }

    public static String getAdminUserAccount() {
        AdminWebContext.PublicParameter p = publicParameterHolder.get();
        return p.getAdminAccount();
    }

    /**
     * 公共参数列表
     */
    @Data
    public static class PublicParameter {

        /**
         * 访问token, 系统颁发，登录后必须传入，所有用户信息将只能通过token换取
         */
        private String token;

        /**
         * 用户IP
         */
        private String ip;

        private int adminUserId;

        private String adminAccount;
    }
}
