package acezhe.zblog.service;

import acezhe.zblog.dao.UserInfoDao;
import acezhe.zblog.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 提供自定义 DetailService 替换 Springboot 默认的。通过 Jpa 从数据库取用户信息。
 */
@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.getUserInfoByUsername(username);

        return User.withUsername(userInfo.getUsername()).password(userInfo.getPassword()).build();
    }
}
