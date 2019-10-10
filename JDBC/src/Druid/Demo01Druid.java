package Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class Demo01Druid {
    public static void main(String[] args) throws Exception {
//        加载配置文件
        Properties pro = new Properties();
        pro.load(Demo01Druid.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
//        获取连接池对象
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
