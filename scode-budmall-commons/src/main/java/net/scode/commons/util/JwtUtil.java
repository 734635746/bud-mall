package net.scode.commons.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

/**
 * Jwt工具类
 *
 * @author liuyoubin
 * @since 2020/4/6 - 17:57
 */
public class JwtUtil {

    /**
     * 过期时间 30分钟
     */
    private static final long EXPIRE_TIME = 1000 * 60 * 30;

    /**
     * 由字符串密钥生成加密密钥
     *
     * @return 加密密钥
     */
    private static SecretKey generalKey(String stringKey) {

        // 本地的密码解码
        byte[] encodedKey = Base64.decodeBase64(stringKey);

        // 根据给定的字节数组使用AES加密算法构造一个密钥
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");

    }

    /**
     * 生成Member的JWT
     *
     * @param claims    需要保存到jwt的业务信息
     * @param stringKey 加密字符串
     * @return JWt
     */
    public static String geneJsonWebToken(Map<String, Object> claims, String stringKey) {

        return Jwts.builder()
                .setClaims(claims) //私有信息,根据特定业务
                .setIssuedAt(new Date()) //签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) //过期时间
                .signWith(SignatureAlgorithm.HS256, generalKey(stringKey))//签名算法及密钥
                .compact();
    }

    /**
     * 校验Token,校验出错会抛出运行时异常
     *
     * @param token     jwt
     * @param stringKey 加密字符串
     * @return Claims信息
     */
    public static Claims checkJWT(String token, String stringKey) {

        return Jwts.parser()
                .setSigningKey(generalKey(stringKey))
                .parseClaimsJws(token)
                .getBody();
    }
}
