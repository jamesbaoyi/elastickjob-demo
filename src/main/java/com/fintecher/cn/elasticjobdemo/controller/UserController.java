package com.fintecher.cn.elasticjobdemo.controller;

import com.fintecher.cn.elasticjobdemo.entity.User;
import com.fintecher.cn.elasticjobdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/18 14:57
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/saveUser")
    private void saveUser() {
        User user = new User();
        user.setCity("甘肃");
        user.setName("张军");
        user.setId(1L);
        userRepository.save(user);
    }

    @GetMapping("/getAllUsers")
    private List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
