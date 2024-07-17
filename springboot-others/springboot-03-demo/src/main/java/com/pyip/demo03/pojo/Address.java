package com.pyip.demo03.pojo;

import lombok.*;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @ClassName: Adress
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 地址
 **/
@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Indexed
    private String city;
    @Indexed
    private String country;
}
