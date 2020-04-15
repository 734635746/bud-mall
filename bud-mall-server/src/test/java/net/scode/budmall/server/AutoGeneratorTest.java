package net.scode.budmall.server;

import net.scode.commons.db.generator.AutoGenerator;
import net.scode.commons.db.generator.GeneratorConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * 代码生成
 *
 * @author tanghuang 2020年02月20日
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class AutoGeneratorTest {

    @Autowired
    private DataSource dataSource;

    /**
     * 生成DAO相关类<br>
     * <font color='red'>注意: 建议生成完后，将已生成过的auto.generate注释掉，避免重新生成覆盖</font>
     */
    @SuppressWarnings("unused")
    @Test
    public void codeGenerate() {
        GeneratorConfig config = new GeneratorConfig();
        config.setMapperDir("resources/mybatis/");
        config.setPackagePrefix("net.scode.budmall.server");
        config.setAuthor("liuyoubin");

        AutoGenerator auto = new AutoGenerator(dataSource);
        //auto.generate(config, "sys_permission", "SysPermission");
        //auto.generate(config, "sys_role", "SysRole");
        //auto.generate(config, "product_category", "ProductCategory");
        //auto.generate(config, "product_brand", "ProductBrand");
        //auto.generate(config, "user_info", "UserInfo");
        //auto.generate(config, "admin_user", "AdminUser");
        //auto.generate(config, "product_info", "ProductInfo");
        //auto.generate(config, "product_service", "ProductService");
        //auto.generate(config, "product_sku", "ProductSku");
        //auto.generate(config, "shop", "Shop");

    }


}
