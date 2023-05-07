package com.chen.config;

import com.chen.vo.RequestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 只要认证成功就会调用本处理
 */
@Component
@Slf4j
public class successhandler implements AuthenticationSuccessHandler {

    /**
     * ObjectMapper 可以进行序列化（json）和反序列化
     */
    @Resource
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //如果认证成功，就返回这些数据给前端，
        RequestResult requestResult=RequestResult.builder()
                .code(1)
                .msg("返回成功")
                .build();
        //将结果对象通过序列化器转换成json格式
        String string = objectMapper.writeValueAsString(requestResult);
        //然后开始响应给前端
        //设置响应编码的字符集
        httpServletResponse.setCharacterEncoding("UTF-8");
        //设置响应数据格式
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //获取书写器，向浏览器或则请求端发起响应
        PrintWriter writer = httpServletResponse.getWriter();
        //返回给前端
        writer.println(string);
        //再刷新一下
        writer.flush();


    }
}
