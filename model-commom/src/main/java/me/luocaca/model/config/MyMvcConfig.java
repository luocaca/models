package me.luocaca.model.config;

import me.luocaca.model.component.LoginHandlerInterceptor;
import me.luocaca.model.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// WebMvcConfigurerAdapter过时,使用WebMvcConfigurer接口
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        System.out.println("-------MyMvcConfig---addInterceptors-添加过滤器---");

        //super.addInterceptors(registry);
        //静态资源： *.css , *.js
        //SpringBoot 映射
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login");


    }


    @Bean
    public WebMvcConfigurer webMvcConfigurer() {

        WebMvcConfigurer webMvcConfigurer = new MyMvcConfig() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                super.addViewControllers(registry);


                registry.addViewController("/")
                        .setViewName("login")
                ;

                registry.addViewController("/index.html")
                        .setViewName("login")
                ;
                registry.addViewController("/main.html")
                        .setViewName("dashboard")
                ;

            }
        };
        return webMvcConfigurer;


    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
