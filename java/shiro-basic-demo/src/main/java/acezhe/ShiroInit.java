package acezhe;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;

/**
 * shiro 初始化
 * @author zhangzhe
 */
public class ShiroInit {
    private static final String DB_URL = "jdbc:sqlite:shirobasicdemo.db";
    private static final String DB_NAME = "basic";
    private static final String AUTH_SQL = "select password,salt from user where username = ?";
    private static final String ROLE_SQL = "select r.role_name from role r left join user_role ur on r.id=ur.role_id left join user u on u.id=ur.user_id where u.username=?";
    private static final String PERMISSION_SQL = "select p.permission_name from role r left join role_permission rp on r.id=rp.role_id left join permission p on rp.permission_id=p.id where r.role_name=?";
    public static final int HASH_ITERATIONS = 1024;

    public static void init() {
        // 创建默认 securityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        // 配置能配置缓存的 session
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        SessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionManager.setSessionDAO(sessionDAO);
        securityManager.setSessionManager(sessionManager);

        // 配置 EhCache 缓存
        EhCacheManager cacheManager = new EhCacheManager();
        securityManager.setCacheManager(cacheManager);

        // 创建 iniRealm
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        // 创建 jdbcRealm
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setSaltStyle(JdbcRealm.SaltStyle.COLUMN);
        jdbcRealm.setDataSource(DatabaseUtils.getDataSource(DB_URL, DB_NAME));
        jdbcRealm.setAuthenticationQuery(AUTH_SQL);
        jdbcRealm.setUserRolesQuery(ROLE_SQL);
        jdbcRealm.setPermissionsQuery(PERMISSION_SQL);
        jdbcRealm.setPermissionsLookupEnabled(true);

        securityManager.setRealm(iniRealm);
        securityManager.setRealm(jdbcRealm);

        // 配置 CredentialsMatcher
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME);
        matcher.setHashIterations(HASH_ITERATIONS);
        matcher.setStoredCredentialsHexEncoded(false);

        jdbcRealm.setCredentialsMatcher(matcher);
    }
}
