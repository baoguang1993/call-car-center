package com.car.cn.carauth.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/me")
    public Principal user2(OAuth2Authentication principal) {
        return principal;
    }
}
