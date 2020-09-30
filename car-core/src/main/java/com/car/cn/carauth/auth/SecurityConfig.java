package com.car.cn.carauth.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "signUserDetailService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource(name = "myCustomerAuthenticationProvider")
    private CustomerAuthenticationProvider customerAuthenticationProvider;
    /**
     * 配置资源服务端的http设置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //定义哪些url需要被保护  哪些不需要保护
                .authorizeRequests()
                //定义这两个链接不需要登录可访问
                .antMatchers("/oauth/token" , "oauth/check_token").permitAll()
                //定义所有的都不需要登录  目前是测试需要
//                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                //.antMatchers("/sys/**").hasRole("admin")///sys/**下的请求 需要有admin的角色
                .and()
                //如果未登录则跳转登录的页面   这儿可以控制登录成功和登录失败跳转的页面
                .formLogin().loginPage("/login")
                //定义号码与密码的parameter
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .csrf().disable();
        //防止跨站请求  spring security中默认开启


    }

    /**
     * 权限管理器  AuthorizationServerConfigurerAdapter认证中心需要的AuthenticationManager需要
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //目的是为了前端获取数据时获取到整个form-data的数据,提供验证器
        auth.authenticationProvider(customerAuthenticationProvider);
        //配置登录user验证处理器  以及密码加密器  好让认证中心进行验证
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    /**
     * 需要配置这个支持password模式
     * support password grant type
     *
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationManager();
    }
}
