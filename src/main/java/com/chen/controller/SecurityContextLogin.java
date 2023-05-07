package com.chen.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


/**
 * 三种获取用户认证信息的方式
 */
@RestController
public class SecurityContextLogin {


    /**
     * 第一种方式，用户信息被存储在这里面
     * @param authentication
     * @return
     */
    @GetMapping("/loginUser1")
    public Authentication authentication(Authentication authentication){
        return authentication;

    }
    /**
     * 第二种方式，用户信息被存储在这里面
     */

    @GetMapping("/loginUser2")
    public Principal principal(Principal principal){
        return principal;
    }

    /**
     * 通过安全上下文持有器获取获取安全上下文，再获取认证信息
     */

    @GetMapping("/loginUser3")
    public Principal principal1(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
