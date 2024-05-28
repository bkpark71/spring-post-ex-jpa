package com.example.ditest.service;

import com.example.ditest.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void addUser() {
        //given
        User user = new User(0, "test2", "qwert", "test2");
        //when
        User savedUser = userService.addUser(user);
        User findUser = userService.getOneUserByUserId("test2");
        //then
        assertThat(savedUser.getId()).isEqualTo(findUser.getId());
    }
}