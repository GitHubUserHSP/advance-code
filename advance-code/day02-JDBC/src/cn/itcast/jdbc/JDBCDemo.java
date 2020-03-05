package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.导入jar包
        //2.注册驱动 //可以省略 因为META-INF/services/java.sql.Driver 不建议
        Class.forName("com.mysql.jdbc.Driver");

        //3.获取数据库连接对象
        //如果要连接本机的mysql 且端口号是默认的3306可省略IP：端口号
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");
        //4.定义sql语句
        String sql="update acount set salary=500 where id=1";
        //5.获取执行sql的对象Statement
        Statement statement = conn.createStatement();
        //6.执行sql
        int i = statement.executeUpdate(sql);
        //7.处理结果
        System.out.println(i);
        //8.关闭资源
        statement.close();
        conn.close();

    }
}
