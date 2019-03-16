package acezhe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author zhangzhe
 */
public class DatabaseUtils{


    private static final String DATABASE_URL = "jdbc:sqlite::memory";
    public Connection getConnection(){
        Connection connection = CONNECTION_THREAD_LOCAL.get();
        try {
        if (!Objects.isNull(connection)&&!connection.isClosed()) {

                return connection;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(DATABASE_URL);
        CONNECTION_THREAD_LOCAL.set(connection);

    }

}
