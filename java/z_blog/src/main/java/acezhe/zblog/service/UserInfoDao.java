package acezhe.zblog.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import acezhe.zblog.entity.UserInfo;

/**
 * 用户信息数据访问层
 */
@Component
public interface UserInfoDao extends JpaRepository<UserInfo,Integer> {

}
