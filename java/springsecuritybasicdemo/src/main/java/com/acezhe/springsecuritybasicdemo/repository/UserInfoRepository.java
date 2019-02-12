package com.acezhe.springsecuritybasicdemo.repository;

import com.acezhe.springsecuritybasicdemo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * All data access method for UserInfo.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findUserInfoByUsername(String username);
}
