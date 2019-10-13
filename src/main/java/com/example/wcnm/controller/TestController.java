package com.example.wcnm.controller;


import com.example.wcnm.DTO.ResultDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public ResultDTO test(){
        ResultDTO<Object> res = ResultDTO.builder()
                .msg("这是一个测试接口")
                .build();
        return res;
    }
}
