package com.example.wcnm.service;

import com.example.wcnm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    User getUserByUserName(String userName);

    void insert(User user);

    List<User> selectUsersByPageAndSize(int page, int size);

    int getAllCount();
}
