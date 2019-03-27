package me.luocaca.model.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@Component
public class DruidConfig {

    @Autowired
    private Environment env;


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }


    // 配置druid 的监控
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");



//        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultListableBeanFactory();
//        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanDefinitionRegistry);
//        propertiesBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("beanConfig.properties"));
//
//
//        propertiesBeanDefinitionReader.getPropertiesPersister().
//
//        BeanFactory factory = (BeanFactory)beanDefinitionRegistry;


        Map<String, String> initParams = new HashMap<>();

        initParams.put("loginUsername", "admin");
//        initParams.put("loginUsername", env.getProperty("durid.username"));
//        initParams.put("loginPassword",  env.getProperty("durid.password"));
        initParams.put("loginPassword",  "123456");
        //默认就是允许所有访问
        initParams.put("allow", "");
        initParams.put("deny", "192.168.15.21");
        bean.setInitParameters(initParams);
        return bean;

    }


    @Bean
    //2. 配置一个web监控的filter
    public FilterRegistrationBean webStatFilter() {

        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;

    }


}
