package com.chen.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder//使用建造者模式创建对象，比直接new 更简单
public class RequestResult {
    private Integer code;//返回给前端的状态码
    private String msg;//返回给前端的信息
    private Object data;//返回给前端的数据对象
}
