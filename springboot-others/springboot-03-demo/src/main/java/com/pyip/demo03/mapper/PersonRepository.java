package com.pyip.demo03.mapper;

import com.pyip.demo03.pojo.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName: PersonRepository
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 接口
 **/
public interface PersonRepository extends CrudRepository<Person,String> {
    List<Person> findByAddress_City(String name);
}
