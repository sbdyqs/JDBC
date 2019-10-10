package C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo02JDBC {
    public static void main(String[] args) throws SQLException {
        testNamedConfig();
    }
    public static void testNamedConfig() throws SQLException {
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for (int i = 0; i < 10; i++) {
            Connection connection = ds.getConnection();
            System.out.println(i + ":" + connection);
            if (i == 5){
                connection.close();
            }
        }
    }
}
