package me.luocaca.model.service.security;


import me.luocaca.model.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;




@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启全局 Securtiy 注解
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration//标识配置类
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
//                .antMatchers().permitAll()
                .anyRequest().authenticated()
                .and()
                // 设置登陆页
                .formLogin()
                // 设置登陆成功页
                .defaultSuccessUrl("/").permitAll()
                //处理登录
//                .loginProcessingUrl("/lf/login")
                // 自定义登陆用户名和密码参数，默认为username和password
//                .usernameParameter("username")
//                .passwordParameter("password")
                .and()
                .logout().permitAll();

//        http.authorizeRequests().antMatchers("/")
//                .permitAll()
//                .antMatchers("/level1/**").hasRole("VIP1")
//                .antMatchers("/level2/**").hasRole("VIP2")
//                .antMatchers("/level3/**").hasRole("VIP3");
//
//        //开启登录功能，如果没权限就来到登录界面
//        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
//                .and()
//                .csrf()
//                .disable()
//                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
//                .anyRequest()               // 任何请求,登录后可以访问
//                .authenticated();


        //开启注销功能,成功注销后回到首页
//        http.logout().logoutSuccessUrl("/");


        // 关闭CSRF跨域
        http.csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("luocaca").password("123456").roles("VIP1", "VIP2")
//                .and()
//                .withUser("cuxx").password("123456").roles("VIP3");


        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        });


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/static/**");

    }
}
