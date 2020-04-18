package net.scode.budmall.server.web;

import lombok.Data;

/**
 * 存放用户前台的上下文信息
 *
 * @author liuyoubin
 * @since 2020/4/18 - 16:25
 */
public class UserAppContext {

    private static final ThreadLocal<PublicParameter> publicParameterHolder = new ThreadLocal<PublicParameter>() {
        @Override
        protected UserAppContext.PublicParameter initialValue() {
            return new UserAppContext.PublicParameter();
        }
    };

    /**
     * 获得公共参数
     */
    public static UserAppContext.PublicParameter getPublicParameter() {
        return publicParameterHolder.get();
    }

    /**
     * 清除
     */
    public static void clear() {
        publicParameterHolder.remove();
    }

    /**
     * 获取用户token
     */
    public static String getToken() {
        PublicParameter publicParameter = publicParameterHolder.get();
        return publicParameter.getToken();
    }

    /**
     * 获取用户ip
     */
    public static String getIP() {
        PublicParameter publicParameter = publicParameterHolder.get();
        return publicParameter.getIp();
    }

    /**
     * 获取用户id
     */
    public static int getUserId() {
        PublicParameter publicParameter = publicParameterHolder.get();
        return publicParameter.getUserId();
    }

    /**
     * 获取用户手机号
     */
    public static String getMobile() {
        PublicParameter publicParameter = publicParameterHolder.get();
        return publicParameter.getMobile();
    }

    /**
     * 用户公共参数
     */
    @Data
    private static class PublicParameter {

        /**
         * 访问token,用户登陆成功后由系统颁发
         */
        private String token;

        /**
         * 用户ip
         */
        private String ip;

        /**
         * 用户id
         */
        private int userId = 1;//没有登陆功能之前的用户模拟

        /**
         * 用户手机号
         */
        private String mobile;
    }

}
