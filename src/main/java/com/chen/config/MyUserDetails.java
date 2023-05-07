package com.chen.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Slf4j
public class MyUserDetails {

    /**
     * 配置用户信息
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {


        /**
         * 创建新用户
         */
        UserDetails user1 = User.builder()
                .username("zhangsan")
                .password(passwordEncoder().encode("123456"))
                .roles("student")
                .build();
        UserDetails user2 = User.builder()
                .username("Lisi")
                .password(passwordEncoder().encode("666666"))
                .roles("teacher")
                /*.authorities("teacher:query")*/
                .build();
      /*  UserDetails user3 = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("000000"))
                .authorities("teacher:query", "teacher:delete", "teacher:add", "teacher:update")
                .build();*/
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);
/*
        userDetailsManager.createUser(user3);
*/

        return userDetailsManager;

    }


    /**
     * 配置密码编码器
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
