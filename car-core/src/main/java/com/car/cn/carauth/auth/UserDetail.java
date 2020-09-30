package com.car.cn.carauth.auth;

import com.libaoguang.cn.cardao.entity.BasisUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetail implements UserDetails , Serializable {
    private BasisUser basisUser;

    private String id;

    /**
     * 通过构造方法在UserDetailsService的方法中将查到的user注入进去
     */
    public UserDetail(BasisUser basisUser) {
        this.basisUser = basisUser;
        if ( basisUser != null ) {
            this.id = basisUser.getId();
        }
    }

    /**
     * 对当前的用户赋予其应有的权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //添加权限
        List authorisList = new ArrayList();

        authorisList.add(new SimpleGrantedAuthority("GG"));

        authorisList.add(new SimpleGrantedAuthority("ROLE_AA"));
        authorisList.add(new SimpleGrantedAuthority("ROLE_BB"));
        authorisList.add(new SimpleGrantedAuthority("ROLE_CC"));
        authorisList.add(new SimpleGrantedAuthority("ROLE_DD"));

        return authorisList;
    }

    /**
     * 获取密码
     */
    @Override
    public String getPassword() {
        return basisUser.getPassword();
    }

    /**
     * 获取用户名
     */
    @Override
    public String getUsername() {
        return basisUser.getUserName();
    }

    /**
     * 账户是否未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 证书是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否有效   可对应数据库中的delete_flag字段
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public BasisUser getUser() {
        return basisUser;
    }

    public void setUser(BasisUser basisUser) {
        this.basisUser = basisUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
