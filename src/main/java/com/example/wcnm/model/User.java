package com.example.wcnm.model;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;

@Data
@Builder
public class User {

    @Tolerate
    public User(){}

    private Integer id;
    private String userName;
    private String password;
    private Boolean sex;
    private String salt;
    private String desc;
    private String imgSrc;
    private Date createTime;
    private String blogUrl;
}
