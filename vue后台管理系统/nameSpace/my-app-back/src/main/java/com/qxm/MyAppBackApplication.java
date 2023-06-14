package com.qxm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author LENOVO
 */
@SpringBootApplication
@MapperScan("com.qxm.mapper")
public class MyAppBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyAppBackApplication.class, args);
    }



}
