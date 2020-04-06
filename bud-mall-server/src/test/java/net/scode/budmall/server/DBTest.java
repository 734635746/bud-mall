package net.scode.budmall.server;

import cn.hutool.crypto.SecureUtil;
import io.jsonwebtoken.Claims;
import net.scode.budmall.server.consts.AdminUserConsts;
import net.scode.budmall.server.po.AdminUser;
import net.scode.budmall.server.service.AdminUserService;
import net.scode.commons.util.JwtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuyoubin
 * @since 2020/4/6 - 14:31
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class DBTest {

    @Autowired
    AdminUserService adminUserService;

    @Test
    public void testInsertAdminUser(){

        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("admin")
                .setLoginPwd(SecureUtil.md5("$ccc$357"))
                .setRoleId(1)
                .setAvatar(AdminUserConsts.DEFAULT_AVATAR)
                .setDataStatus(2);

        adminUserService.save(adminUser);

    }

}
