package me.luocaca.model.config;

import me.luocaca.model.component.LoginHandlerInterceptor;
import me.luocaca.model.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
// WebMvcConfigurerAdapter过时,使用WebMvcConfigurer接口
public class MyMvcConfig implements WebMvcConfigurer {



    public static LoginHandlerInterceptor loginHandlerInterceptor = null;
    public static LocaleResolver localeResolver = null;
    public static WebMvcConfigurer webMvcConfigurer = null;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        if (loginHandlerInterceptor == null) {


            System.out.println("-------MyMvcConfig---addInterceptors-添加过滤器---");
            loginHandlerInterceptor = new LoginHandlerInterceptor();
            //super.addInterceptors(registry);
            //静态资源： *.css , *.js
            //SpringBoot 映射
            registry.addInterceptor(loginHandlerInterceptor)
                    .addPathPatterns("/**")
                    .excludePathPatterns("/index.html", "/", "/user/login");

        }


    }






    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        System.out.println("-----------webMvcConfigurer---------------");
        if (webMvcConfigurer == null) {
            webMvcConfigurer = new MyMvcConfig() {
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

        } else {
            return null;
        }


    }

    @Bean
    public LocaleResolver localeResolver() {

        if (localeResolver == null) {
            return new MyLocaleResolver();
        } else {
            return null;
        }


    }


    @Bean
    public InternalResourceViewResolver InternalResourceViewResolverProvider() {


        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

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
