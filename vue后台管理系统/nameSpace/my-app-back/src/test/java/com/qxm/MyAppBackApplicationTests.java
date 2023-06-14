package com.qxm;

import com.qxm.mapper.UserMapper;
import com.qxm.pojo.User;
import com.qxm.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class MyAppBackApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
//        List<User> user = new ArrayList<>();
//
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i <5000 ; i++) {
//
//            User user1 = new User(i+1, "乔玺铭" + i, "26", "男", null, "张家庄", null, null);
//            userMapper.insert(user1);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("插入耗时时间:"+(endTime-startTime));

    }
    /**
     * 头部：
     * iss: jwt签发者
     * sub: jwt所面向的用户
     * aud: 接收jwt的一方
     * exp: jwt的过期时间，这个过期时间必须要大于签发时间
     * nbf: 定义在什么时间之前，该jwt都是不可用的.
     * iat: jwt的签发时间
     * jti: jwt的唯一身份标识，主要用来作为一次性token。
     */

    /**
     * jwt测试 创建token令牌  jwt
     * 头部: 类型:jwt 加密算法hs256
     *载荷 : 数据信息
     * 签名： 私钥 解密与验证
     * 唯一标识：5c4e8001-2ac1-4040-b5ea-6908006c77ff
     */
    @Test
    void test1(){

        JwtBuilder builder = Jwts.builder()
                .setId("5c4e8001-2ac1-4040-b5ea-6908006c77ff") //设置唯一编号
                .setSubject("myApp") //设置主题 可以是JSON数据
                .setIssuedAt(new Date()) //设置签发日期
                .signWith(SignatureAlgorithm.HS256,"qxm_app");
        System.out.println(builder.compact());
    }

    @Test
    void test2(){
        System.out.println(UUID.randomUUID().toString());
    }

    /**
     * 解析令牌
     * eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1YzRlODAwMS0yYWMxLTQwNDAtYjVlYS02OTA4MDA2Yzc3ZmYiLCJzdWIiOiJteUFwcCIsImlhdCI6MTY4NjMxMDYyMH0.FdQrFKGDNYDyvMUoyJRJe2YVu7oXaZXvLUXvdobMLNs
     */
    @Test
    void test3(){
        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1YzRlODAwMS0yYWMxLTQwNDAtYjVlYS02OTA4MDA2Yzc3ZmYiLCJzdWIiOiJteUFwcCIsImlhdCI6MTY4NjMxMDYyMH0.FdQrFKGDNYDyvMUoyJRJe2YVu7oXaZXvLUXvdobMLNs";
        Claims qxm_app = Jwts.parser().setSigningKey("qxm_app").parseClaimsJws(token).getBody();
        System.out.println(qxm_app);

    }
}
