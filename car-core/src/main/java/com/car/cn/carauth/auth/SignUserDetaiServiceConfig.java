package com.car.cn.carauth.auth;

import com.car.cn.carauth.service.CarUserDetailsService;
import com.libaoguang.cn.cardao.entity.BasisUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("signUserDetailService")
public class SignUserDetaiServiceConfig implements UserDetailsService {
    @Autowired
    private CarUserDetailsService carUserDetailsService;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        BasisUser currentUser = carUserDetailsService.getByName(name);
        if ( currentUser == null ) {
            throw new UsernameNotFoundException("用户没用找到");
        }

        return new UserDetail(currentUser);
    }
}
