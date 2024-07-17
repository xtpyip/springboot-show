package com.pyip.demo03;

//import com.pyip.demo03.mapper.ArticleMapper;
//import com.pyip.demo03.mapper.CommentMapper;
//import com.pyip.demo03.mapper.CommentRepository;
//import com.pyip.demo03.pojo.Article;
//import com.pyip.demo03.pojo.Comment;
import com.pyip.demo03.mapper.PersonRepository;
import com.pyip.demo03.pojo.Address;
import com.pyip.demo03.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: SpringBootApplicationTest
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 测试类
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationTest {
//    @Autowired
//    public CommentMapper commentMapper;
//
//    @Test
//    public void test01(){
//        Comment comment = commentMapper.findById(1);
//        // Comment(id=1, content=很全，很详细, author=luccy, aId=null)
//        System.out.println(comment);
//    }
//
//    @Autowired
//    public ArticleMapper articleMapper;
//
//    @Test
//    public void test02(){
//        // Article(id=1, content=从入门到精通, title=Spring Boot基础入门)
//        // Article(id=2, content=从入门到精通, title=Spring cloud基础入门)
//        List<Article> articles = articleMapper.selectArticle();
//        for (Article article : articles) {
//            System.out.println(article);
//        }
//    }
//    @Autowired
//    private CommentRepository commentRepository;
//    @Test
//    public void test03(){
//        /**
//         * Comment(id=1, content=很全，很详细, author=luccy, aId=1)
//         * Comment(id=2, content=赞一个, author=tom, aId=1)
//         * Comment(id=3, content=很详细, author=eric, aId=1)
//         * Comment(id=4, content=很好，非常详细, author=张三, aId=1)
//         * Comment(id=5, content=很不错, author=李四, aId=2)
//         */
//        List<Comment> all = commentRepository.findAll();
//        for (Comment comment : all) {
//            System.out.println(comment);
//        }
//    }
    @Autowired
    private PersonRepository personRepository;
    @Test
    public void test03(){
        Person person = new Person();
        person.setFirstname("张");
        person.setLastname("三");

        Address address = new Address();
        address.setCity("北京");
        address.setCountry("中国");
        person.setAddress(address);

        personRepository.save(person);
    }
    @Test
    public void test04(){
        List<Person> list = personRepository.findByAddress_City("北京");
        for (Person person : list) {
            // Person(id=294d1e3e-fbab-40b3-827e-64a101b85df0, firstname=张, lastname=三, address=Address(city=北京, country=中国))
            System.out.println(person);
        }
    }
}
