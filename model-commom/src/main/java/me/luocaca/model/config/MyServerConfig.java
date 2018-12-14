package me.luocaca.model.config;

import me.luocaca.model.filter.MyFilter;
import me.luocaca.model.listener.MyListener;
import me.luocaca.model.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class MyServerConfig {


    //注册三大件
    @Bean
    public ServletRegistrationBean myServlet() {

        System.out.println("MyServerConfig-----> myServlet ------ ");


        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");

        registrationBean.setLoadOnStartup(1);
        return registrationBean;


    }

    @Bean
    public FilterRegistrationBean myFilter() {
        System.out.println("MyServerConfig-----> myFilter ------ ");
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));

        return registrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean myListener() {

        System.out.println("MyServerConfig-----> myListener ------ ");

        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }


    //配置嵌入式的Servlet容器
//    @Bean
//    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
//        //定制嵌入式的Servlet容器相关的规则
//
//
//        System.out.println("EmbeddedServletContainerCustomizer-----> 8080 ------ ");
//
//
//        return container -> container.setPort(8080);
//    }


}
