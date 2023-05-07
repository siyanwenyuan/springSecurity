package com.chen.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;


@Configuration
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //将认证成功处理器注入
    @Resource
    private successhandler successhandler;
    @Resource
    private failerHandler failerHandler;
    @Resource
    private LogoutSuccessHandler logoutSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();

        http.formLogin()
                .successHandler(successhandler)//登录认证成功后，则执行这个处理器
                .failureHandler(failerHandler)//登录失败成功后，则执行这个处理器


                .permitAll();
        http.logout().logoutSuccessHandler(logoutSuccessHandler);//配置退出成功处理器


    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }



}
