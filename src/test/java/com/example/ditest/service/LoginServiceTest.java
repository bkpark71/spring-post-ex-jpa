package com.example.ditest.service;

import com.example.ditest.dto.LoginDto;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Test
    void loginProcess() {
        //given
        LoginDto loginDto = new LoginDto("test1", "qwert");
        //when
        boolean b = loginService.loginProcess(loginDto);
        //then
        assertThat(b).isEqualTo(true);
    }
}