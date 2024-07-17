package com.pyip.demo03.pojo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @ClassName: Person
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 实体类
 **/

@RedisHash("persons")
@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private String id;
    @Indexed
    private String firstname;
    @Indexed
    private String lastname;
    private Address address;
}
