package com.huo.msb.java.hellospringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huo.msb.java.hellospringboot.account.mapper")
public class HelloSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringbootApplication.class, args);
    }

}
