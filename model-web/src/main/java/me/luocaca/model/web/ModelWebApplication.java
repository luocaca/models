package me.luocaca.model.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * spring jsp 项目的引入
 * https://www.cnblogs.com/sxdcgaq8080/p/7712874.html
 */
@SpringBootApplication
@MapperScan("me.luocaca.model.mapper")
public class ModelWebApplication extends SpringBootServletInitializer {

//    public static void main(String[] args) {
//        SpringApplication.run(ModelWebApplication.class, args);
//    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(ModelWebApplication.class);
//    }


    public static void main(String[] args) {
        SpringApplication.run(ModelWebApplication.class, args);
    }

}
