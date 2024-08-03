package com.pyip.springboot.mapper;

import com.pyip.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    
    void save(User user);
    
    List<User> findAll();
}