package acezhe.zblog.dao;

import acezhe.zblog.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * 用户信息数据访问层
 */
@Component
public interface UserInfoDao extends JpaRepository<UserInfo,Integer> {
    UserInfo getUserInfoByUsername(String username);
}
