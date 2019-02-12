package com.acezhe.springsecuritybasicdemo.service;

import com.acezhe.springsecuritybasicdemo.entity.UserInfo;
import com.acezhe.springsecuritybasicdemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * User's service tools, implement UserDetailsService to offer a method used by
 * security manage.
 */
@Service
public class UserService implements UserDetailsService {
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findUserInfoByUsername(username);
        if (null == userInfo) {
            throw new UsernameNotFoundException("用户未找到");
        } else {
            return User.builder()
                    .username(userInfo.getUsername())
                    .password(userInfo.getPassword())
                    .roles(userInfo.getRole()).build();
        }
    }

    public UserInfo register(UserInfo userInfo) {
        userInfo.setPassword(getBCryptPasswordEncoder().encode(userInfo.getPassword()));
        return userInfoRepository.save(userInfo);
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
