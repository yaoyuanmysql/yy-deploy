package com.yy.deploy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author yaoyuan
 */
@MapperScan(basePackages = {
        "com.yy.deploy.server.dao",
        "com.yy.deploy.docker.dao",
        "com.yy.deploy.build.dao"
})
@SpringBootApplication
public class YyDeployPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(YyDeployPlusApplication.class, args);
    }

}
