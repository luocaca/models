package me.luocaca.model.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * spring jsp 项目的引入
 * https://www.cnblogs.com/sxdcgaq8080/p/7712874.html
 */
@SpringBootApplication
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
