package acezhe;


import com.github.javatlacati.contiperf.PerfTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import static org.junit.Assert.*;


public class DatabaseUtilsTest {



    @Test
    @PerfTest(threads = 10,invocations = 10)
    public void testGetConnectionAndClose() throws InterruptedException, SQLException {
            Connection connection = DatabaseUtils.getConnection();
            assertEquals(false,connection.isClosed());
            Thread.sleep(Math.round(Math.random()*10000));
            assertEquals(false,connection.isClosed());
            DatabaseUtils.close();
            assertEquals(true,connection.isClosed());
    }
}
