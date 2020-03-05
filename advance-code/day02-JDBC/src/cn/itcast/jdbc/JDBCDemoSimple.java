package cn.itcast.jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*使用jdbc工具类简化*/
public class JDBCDemoSimple {
    public static void main(String[] args) throws SQLException {
        //1.导入jar包
        //2.注册驱动 //可以省略 因为META-INF/services/java.sql.Driver 不建议


        //3.获取数据库连接对象
        Connection conn = JDBCUtils.getConnection();

        String sql="update acount set salary=600 where id=1";
        //5.获取执行sql的对象Statement
        Statement statement = conn.createStatement();
        //6.执行sql
        int i = statement.executeUpdate(sql);
        //7.处理结果
        System.out.println(i);
        //8.关闭资源

        JDBCUtils.close(statement,conn);

    }
}
