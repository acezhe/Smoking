package acezhe;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * 一个包装了 Connection 的类, 提供在多线程下安全获取 Connection 的方式
 * 默认使用内存数据库
 * @author zhangzhe
 */
@Log4j2
public class DatabaseUtils {
    private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    private static String dataBaseUrl = "jdbc:sqlite::memory:";

    /**
     * 隐藏构造方法
     */
    private DatabaseUtils() {
    }

    /**
     * 获取运行线程的 Connection
     *
     * @return Connection 对象
     */
    public static Connection getConnection() {
        Connection connection = connectionThreadLocal.get();
        try {
            if (!Objects.isNull(connection) && !connection.isClosed()) {
                return connection;
            }
            connection = DriverManager.getConnection(dataBaseUrl);
        } catch (SQLException se) {
            log.error("Get sqlite connection error.", se);
        }

        connectionThreadLocal.set(connection);
        return connection;
    }

    public static void setUrl(String url){
        dataBaseUrl = url;
    }


    /**
     * 关闭 Connection，并清除运行线程中的 Connection 变量
     */
    public static void close() {
        Connection connection = connectionThreadLocal.get();
        try {
            if (!Objects.isNull(connection) && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException se) {
            log.error("Close sqlite connection error.", se);
        }
        connectionThreadLocal.remove();
    }
}