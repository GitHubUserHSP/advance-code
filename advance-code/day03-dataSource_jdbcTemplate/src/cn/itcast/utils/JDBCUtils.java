package cn.itcast.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*Druid连接池工具类
* */
public class JDBCUtils {
    //1.定义成员变量 DataSource
    private static DataSource ds;
    static{
        try {
            //1.加载配置文件
            Properties pro=new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            try {
                //2.获取DataSource对象
                ds = DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }
    public static void close(Statement stat, Connection conn) {
        /*if(stat!=null){
            try {
                stat.close();//此处异常之所以处理而不同于上面获取连接方法的声明抛出，是为了简单
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }

        }*/
        //调用下方三个参数的方法，第一个传空值实现简化编写
        close(null,stat,conn);

    }
    public static void close(ResultSet rs, Statement stat, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //获取数据库连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
}
