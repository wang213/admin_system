package com.qxm.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    //有效期
    public static final Long JWT_TTL=1000L*60*60*24*30;

    //密钥明文
    public static final String JWT_KEY="qxm_app";

    /**
     * 生成密钥密文
     */
    public static SecretKey genetalKey(){
        byte[] bytes = Base64.getEncoder().encode(JwtUtil.JWT_KEY.getBytes());
        SecretKeySpec secretKey = new SecretKeySpec(bytes, 0, bytes.length, "aes");
        return secretKey;
    }

    /**
     *
     * @param id  设置唯一编号
     * @param subject 主题
     * @param ttlMills 有效期
     * @return
     */
    public static String createJWT(String id,String subject,Long ttlMills){
        if(ttlMills == null){
            ttlMills = JWT_TTL;
        }
        Date expDate=new Date(System.currentTimeMillis()+ttlMills);

        //获得密钥密文
        SecretKey secretKey = genetalKey();

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id) //唯一标识
                .setSubject(subject) //主体信息
                .setIssuer("admin") //签发人
                .setIssuedAt(new Date()) //签发日期
                .setExpiration(expDate) //有效期
                .signWith(SignatureAlgorithm.HS256, secretKey);//签名 (算法,密钥)
        return jwtBuilder.compact();
    }
}
