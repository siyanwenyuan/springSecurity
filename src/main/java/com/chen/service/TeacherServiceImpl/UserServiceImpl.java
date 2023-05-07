package com.chen.service.TeacherServiceImpl;

import com.chen.vo.securityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class UserServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!StringUtils.hasText(username)){
            throw  new UsernameNotFoundException("用户名不存在");
        }
        if(!username.equals("zhangsan")){
            throw  new UsernameNotFoundException("用户名不存在");
        }
        securityUser securityUser=new securityUser();
        return securityUser;
    }
}
