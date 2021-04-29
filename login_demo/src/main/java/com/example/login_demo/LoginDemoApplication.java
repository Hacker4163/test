package com.example.login_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan("com.example.login_demo.mapper")
public class LoginDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginDemoApplication.class, args);
    }

}
