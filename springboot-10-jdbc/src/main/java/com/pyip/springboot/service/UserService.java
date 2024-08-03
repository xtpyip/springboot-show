package com.pyip.springboot.service;

import com.pyip.springboot.dao.UserDao;
import com.pyip.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: UserService
 * @version: 1.0
 * @Author: pyipXt
 * @Description: TODO
 **/
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public void test(){
        User user = new User();
        user.setName("test dao");
        user.setTel("1234567");

        userDao.save(user);
        List<User> userList = userDao.findAll();
        userList.forEach(System.out::println);

    }

}
