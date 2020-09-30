package com.car.cn.carauth.auth;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 * 定义资源服务器，用注解@EnableResourceServer；
 * 定义授权服务器，用注解@EnableAuthorizationServer；
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TokenStore tokenStore;

    /**
     * 认证管理器
     */
    @Autowired
    private  AuthenticationManager authenticationManager;

    /**
     * 自定义登录或者鉴权失败时的返回信息
     */
    @Resource(name = "webResponseExceptionTranslator")
   private WebResponseExceptionTranslator webResponseExceptionTranslator;


    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }

    /**
     * 客户端详情服务配置 （读取jdbc）
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    /**
     * 配置访问令牌端点
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // 认证管理器
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore);
        endpoints.exceptionTranslator(webResponseExceptionTranslator);
    }

    /**
     * 配置令牌端点安全约束
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        CorsConfigurationSource source = new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration corsConfiguration = new CorsConfiguration();
                corsConfiguration.addAllowedHeader("*");
                corsConfiguration.addAllowedOrigin(request.getHeader(HttpHeaders.ORIGIN));
                corsConfiguration.addAllowedMethod("*");
                corsConfiguration.setAllowCredentials(true);
                corsConfiguration.setMaxAge(3600L);
                return corsConfiguration;
            }
        };
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients()
                .addTokenEndpointAuthenticationFilter(new CorsFilter(source));
    }



}
