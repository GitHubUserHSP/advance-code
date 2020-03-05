package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.SQLException;

public class C3P0Demo {
    public static void main(String[] args) throws SQLException {
        //1.导jar包
        //2.定义配置文件
        //3.创建数据库连接池对象
        DataSource ds=new ComboPooledDataSource();//不传参数使用xml下的default 传参 改name<named-config name="otherc3p0">
        //DataSource da=new ComboPooledDataSource("otherc3p0");
        for (int i = 0; i < 10; i++) {
            Connection conn = ds.getConnection();
            if(i==5){
                conn.close();//在这里不是关闭连接，是归还连接到连接池中
            }
        }

    }
}
