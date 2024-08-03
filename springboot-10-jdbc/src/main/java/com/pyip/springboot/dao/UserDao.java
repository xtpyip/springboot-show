package com.pyip.springboot.dao;

import com.pyip.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: UserDao
 * @version: 1.0
 * @Author: pyipXt
 * @Description: Dao
 **/
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(User user){
        jdbcTemplate.update(("insert into tbl_user(name,tel) values (?,?)"),user.getName(),user.getTel());
    }

    public List<User> findAll(){
        return jdbcTemplate.query("select * from tbl_user",
                BeanPropertyRowMapper.newInstance(User.class));
    }



}
