package Jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//@SuppressWarnings("all")
public class Demo05Jdbc {
    public static List<Emp> findAll() {
        ArrayList<Emp> list = new ArrayList<>();
        Emp emp = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "0506");
            stmt = conn.createStatement();
            String sql = "select * from emp";
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                emp = new Emp();
                emp.setId(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob_id(rs.getInt(3));
                emp.setMgr(rs.getInt(4));
                emp.setJoindate(rs.getString(5));
                emp.setSalary(rs.getDouble(6));
                emp.setBouns(rs.getDouble(7));
                emp.setDept_id(rs.getInt(8));
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Emp> all = findAll();
        for (Emp emp : all) {
            System.out.println(emp);
        }
    }
}
