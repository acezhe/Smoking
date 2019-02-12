package com.acezhe.springsecuritybasicdemo.repository;

import com.acezhe.springsecuritybasicdemo.SpringsecuritybasicdemoApplicationTests;
import com.acezhe.springsecuritybasicdemo.entity.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserInfoRepositoryTest extends SpringsecuritybasicdemoApplicationTests {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void dbtest(){
        UserInfo u1 = new UserInfo("asdf","asdf","USER");
        userInfoRepository.saveAndFlush(u1);

        UserInfo userInfo = userInfoRepository.findUserInfoByUsername("asdf");
        System.out.println(userInfo);
    }

}