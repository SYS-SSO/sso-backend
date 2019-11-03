package com.example.wcnm.dao;

import com.example.wcnm.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void insert(@Param("user") User user);


    User selectUserByUserName(@Param("username")String username);

    List<User> selectUsersByPageAndSize(@Param("page")int page,@Param("size")int size);

    int getAllCount();
}
