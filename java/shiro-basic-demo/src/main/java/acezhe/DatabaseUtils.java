package acezhe;

import lombok.extern.log4j.Log4j2;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/**
 * 一个包装了 Connection 的类, 提供在多线程下安全获取 Connection 的方式
 * 默认使用内存数据库
 *
 * @author zhangzhe
 */
@Log4j2
public class DatabaseUtils {
    private static final String dataBaseUrl = "jdbc:sqlite::memory:";
    private static SQLiteDataSource sqLiteDataSource = null;

    /**
     * 隐藏构造方法
     */
    private DatabaseUtils() {
    }

    public static SQLiteDataSource getDataSource(String url, String name) {
        if (null == sqLiteDataSource) {
            SQLiteDataSource dataSource = new SQLiteDataSource();
            if (null != url) {
                dataSource.setUrl(url);
            } else {
                dataSource.setUrl(dataBaseUrl);
            }
            if (null != name) {
                dataSource.setDatabaseName(name);
            }
            sqLiteDataSource = dataSource;
        }
        return sqLiteDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return sqLiteDataSource.getConnection();
    }
}