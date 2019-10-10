package C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo01JDBC {
    public static void main(String[] args) {
        DataSource ds = new ComboPooledDataSource();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
