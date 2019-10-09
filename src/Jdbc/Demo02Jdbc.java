package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo02Jdbc {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "0506");
//        String sql = "insert into account(name,balance) values ('wangwu',300);";
//        String sql = "update account set balance = 1000 where name = 'wangwu';";
        String sql = "delete from account where name = 'lisi'; ";
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        statement.close();
        connection.close();

    }
}
