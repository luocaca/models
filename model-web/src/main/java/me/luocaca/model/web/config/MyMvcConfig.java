package me.luocaca.model.web.config;

import me.luocaca.model.component.LoginHandlerInterceptor;
import me.luocaca.model.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
// WebMvcConfigurerAdapter过时,使用WebMvcConfigurer接口
public class MyMvcConfig extends WebMvcConfigurerAdapter {





    @Bean
    public InternalResourceViewResolver InternalResourceViewResolverProvider() {


        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setViewNames("jsp/*");
        internalResourceViewResolver.setOrder(2);
//        Map map = new HashMap();
//        map.put("", "");
//        map.put("", "");
//        map.put("", "");
//        map.put("", "");
//        map.put("", "");
//        internalResourceViewResolver.setAttributesMap(map);
        return internalResourceViewResolver;
    }



}
