package Jdbc;

import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo06Jdbc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();
        boolean flag = Demo06Jdbc.login(username, password);
        if (flag){
            System.out.println("登录成功!");
        }else {
            System.out.println("用户名或密码错误!");
        }
    }
    public static boolean login(String username, String password){
        if (username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }
}
