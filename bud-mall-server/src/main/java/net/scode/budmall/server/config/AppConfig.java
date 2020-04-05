package net.scode.budmall.server.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 应用配置
 *
 * @author tanghuang 2020年02月21日
 */
@Data
@Component
public class AppConfig {

    /**
     * 环境
     */
    @Value("${spring.profiles.active}")
    private String env;

    /**
     * 解决因通过nginx做二级url映射后无法测试的问题
     */
    @Value("${swagger.host}")
    private String swaggerHost;

}
