package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 *使用Druid连接池工具类
 */
public class DruidTest {
    public static void main(String[] args)  {
        /*完成添加操作：给db1的account表添加一条记录（两种方法，推荐第一种，使用prepareStatement解决SQL注入问题）
        * */
        Connection conn= null;
        PreparedStatement pS =null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="insert into account values(null,?,?)";//id主键可以不写，由于主键使用自增长,""内末尾不要加;
            pS = conn.prepareStatement(sql);//解决SQL注入问题

            pS.setString(1,"张三");
            pS.setDouble(2,600.00);

            int i = pS.executeUpdate();//上面prepareStatement方法内部传过sql这里可省
            System.out.println("受影响行数"+i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pS,conn);

        }



        /*DataSource dS = JDBCUtils.getDataSource();
        Connection connection = dS.getConnection();

        String sql2="insert into account values(4,'赵六',700)";
        Statement stat = connection.createStatement();
        stat.executeUpdate(sql2);
        JDBCUtils.close(stat,connection);*/


    }
}
