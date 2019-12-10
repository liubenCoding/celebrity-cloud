package com.lb.celebrity_server_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.lb.celebrity_server_user.mapper")
public class CelebrityServerUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(CelebrityServerUserApplication.class, args);
    }
}
