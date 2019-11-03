package com.example.wcnm.service.impl;

import com.example.wcnm.dao.UserMapper;
import com.example.wcnm.model.User;
import com.example.wcnm.service.IUserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        if(StringUtils.isEmpty(userName)){
            return null;
        }
        return userMapper.selectUserByUserName(userName);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> selectUsersByPageAndSize(int page, int size) {
        if(!(page>0 && size>0)){
            return null;
        }
        int start = page - 1;
        return userMapper.selectUsersByPageAndSize(start*size,page*size);
    }

    @Override
    public int getAllCount() {
        return userMapper.getAllCount();
    }
}
