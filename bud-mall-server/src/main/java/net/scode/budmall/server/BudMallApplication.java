package net.scode.budmall.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot启动类
 *
 * @author tanghuang 2020年02月20日
 */
@EnableTransactionManagement
@SpringBootApplication
public class BudMallApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BudMallApplication.class);
        springApplication.run(args);
    }

}
