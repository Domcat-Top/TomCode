package com.tom.testmodule.controller;

import com.tom.testmodule.entity.UserEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URL;

/**
 * @author: Tom
 * @date: 2023/12/11 13:47
 * @description:
 */
@RestController
public class UserDaoImpl {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 增
     *
     * @param user
     */
    @PostMapping("/testSave")
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    @GetMapping("/getInfo")
    public UserEntity findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
        return user;
    }

    /**
     * 更新对象
     *
     * @param user
     */
    @PostMapping("updateInfo")
    public void updateUser(UserEntity user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        // 更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, UserEntity.class);
        // 更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    /**
     * 删除对象
     *
     * @param id
     */
    @PostMapping("testDel")
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, UserEntity.class);
    }
}
