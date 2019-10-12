package JDBCTemplate;

import Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Demo01JDBCTemplate {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update account set balance = 1000 where id = ?";
        int i = template.update(sql, 4);
        System.out.println(i);

        String sql1 = "update emp set salary = 10000 where id = ?";
        int i1 = template.update(sql1, 1001);
        System.out.println(i1);
    }
}

