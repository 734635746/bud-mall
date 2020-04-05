package net.scode.budmall.server.web;

import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.consts.AuthConsts;
import net.scode.commons.web.RequestUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理后台业务相关拦截器
 *
 * @author tanghuang 2020年02月25日
 */
@Slf4j
public class AdminServiceInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     *
     * @param request
     * @param response
     * @param handler
     * @return true，如果false，停止流程，api被拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        // 填充公共参数
        String bearToken = request.getHeader(AuthConsts.AUTHORIZATION_HEADER);
        if (StringUtils.isEmpty(bearToken)) {
            bearToken = request.getParameter("token");
            log.info("header 中token 为空，尝试从request中获取:{}", bearToken);
        }
        String ip = RequestUtil.getRemoteAddr(request);
        AdminWebContext.PublicParameter publicParameter = AdminWebContext.getPublicParameter();
        publicParameter.setToken(bearToken);
        publicParameter.setIp(ip);

        // 检查token
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // TODO
        return true;
    }

}
