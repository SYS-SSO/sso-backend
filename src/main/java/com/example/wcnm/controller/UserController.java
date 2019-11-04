package com.example.wcnm.controller;

import com.example.wcnm.DTO.Page;
import com.example.wcnm.DTO.ResultDTO;
import com.example.wcnm.model.User;
import com.example.wcnm.service.IUserService;
import io.swagger.annotations.Api;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
@Api(value = "用户注册")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public ResultDTO signUp(@RequestBody User user) {
        if(validateUser(user.getUserName()) == 1){
            ResultDTO<Object> resultDTO = new ResultDTO();
            resultDTO.setCode(202);
            resultDTO.setMsg("对不起，该用户名已被注册，请使用其他用户名!");
            return resultDTO;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.insert(user);
        ResultDTO<Object> result = new ResultDTO();
        result.setMsg("恭喜你，注册成功!");
        return result;
    }


    public int validateUser(String userName){
        if(StringUtils.isEmpty(userName)){
            return 1;
        }
        User user = userService.getUserByUserName(userName);
        if(Objects.nonNull(user)){
            return 1;
        }
        return 0;
    }

    @GetMapping(value = "/getUserLs")
    public ResultDTO<List<User>> getUserLsByPageAndSize(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                             @RequestParam(value = "size",defaultValue = "10")Integer size){
        ResultDTO<List<User>> listResultDTO = new ResultDTO<>();
        if(Objects.isNull(page)||Objects.isNull(size)){
            return listResultDTO;
        }
        try {
            listResultDTO.setPage(new Page(userService.getAllCount(), page, size));
            List<User> users = userService.selectUsersByPageAndSize(page, size);
            listResultDTO.setBody(users);
        }catch (Exception e){
            e.printStackTrace();
        }
        return listResultDTO;
    }

}