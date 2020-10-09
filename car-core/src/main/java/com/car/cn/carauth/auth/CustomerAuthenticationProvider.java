package com.car.cn.carauth.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("myCustomerAuthenticationProvider")
public class CustomerAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerAuthenticationProvider.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource(name = "signUserDetailService")
    private UserDetailsService userDetailsService;

    /**
     * 手动实现认证
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails , UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if ( authentication.getCredentials() == null ) {
            this.logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials" , "Bad credentials"));
        } else {
            String presentedPassword = authentication.getCredentials().toString();
            if ( !this.passwordEncoder.matches(presentedPassword , userDetails.getPassword()) ) {
                this.logger.debug("Authentication failed: password does not match stored value");
                throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials" , "Bad credentials"));
            }
        }
    }

    /**
     * 手动加载user
     */
    @Override
    protected UserDetails retrieveUser(String s , UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(s);
    }

}
