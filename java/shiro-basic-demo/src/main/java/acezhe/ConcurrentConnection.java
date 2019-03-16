package acezhe;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * 一个包装了 Connection 的类, 提供在多线程下安全获取 Connection 的方式
 * @author zhangzhe
 */
@L
public class ConcurrentConnection implements Closeable {
    private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    /**
     * 隐藏构造方法,通过单例获取实例
     */
    private ConcurrentConnection(){
    }

    /**
     * 获取 ConcurrentConnection 实例
     * 单例模式实现, 始终只存在一个对象
     * @return ConcurrentConnection 对象
     */
    public static ConcurrentConnection getInstance(){
        return ConcurrentConnectionHolder.concurrentConnection;
    }

    /**
     * 获取运行线程的 Connection
     * @param url sqlite 数据库地址
     * @return Connection 对象
     */
    public Connection getConnection(String url) {
        Connection connection = connectionThreadLocal.get();
        try {
            if (!Objects.isNull(connection)&&!connection.isClosed()){
                return connection;
            }
        } catch (SQLException e) {

        }

        connection = DriverManager.getConnection(url);
        connectionThreadLocal.set(connection);
        return connection;
    }

    @Override
    public void close() throws IOException {

    }

    private static class ConcurrentConnectionHolder{
        private static final ConcurrentConnection concurrentConnection = new ConcurrentConnection();
    }
}
