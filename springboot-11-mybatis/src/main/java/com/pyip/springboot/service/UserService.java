package com.pyip.springboot.service;

import com.pyip.springboot.entity.User;
import com.pyip.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        User user = new User();
        user.setName("test mybatis");
        user.setTel("7654321");
        userMapper.save(user);
    
//        int i = 1 / 0;
        
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }
}