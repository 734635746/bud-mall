package net.scode.budmall.server.web;

import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.consts.AdminUserConsts;
import net.scode.budmall.server.consts.AuthConsts;
import net.scode.commons.constant.Consts;
import net.scode.commons.core.R;
import net.scode.commons.util.JwtUtil;
import net.scode.commons.web.RequestUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * 管理后台业务相关拦截器
 *
 * @author tanghuang 2020年02月25日
 */
@Slf4j
public class AdminServiceInterceptor implements HandlerInterceptor {
    private static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";

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

        if (StringUtils.isEmpty(bearToken)) {
            setResponse(response, R.error(Consts.NOT_LOGIN_CODE, "未登录"));
            return false;
        }

        Claims claims = JwtUtil.checkJWT(bearToken, AdminUserConsts.JWT_SECRET);
        int userId = (int) claims.get("id");
        String account = (String) claims.get("account");
        publicParameter.setAdminUserId(userId);
        publicParameter.setAdminAccount(account);

        // TODO token自动续期

        // 检查token
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // TODO
        }

        return true;
    }

    private void setResponse(ServletResponse response, R result) {
        try {
            OutputStream os = response.getOutputStream();
            String jsonStr = JSONUtil.toJsonStr(result);
            os.write(jsonStr.getBytes(StandardCharsets.UTF_8));
            response.setContentType(JSON_CONTENT_TYPE);
        } catch (Exception ex) {
            log.warn("exception=" + ex);
        }
    }
}
