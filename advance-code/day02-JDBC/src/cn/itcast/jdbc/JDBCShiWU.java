package cn.itcast.jdbc;

import util.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*Connection对象管理事务实现转账*/
public class JDBCShiWU {
    public static void main(String[] args) {
        //1.导入jar包
        //2.注册驱动
        PreparedStatement pS=null;
        PreparedStatement pS2=null;
        Connection conn =null;
        //3.获取数据库连接对象
        try {
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            //5.获取执行sql的对象PreparedStatement
            String sql="update acount set salary=salary-? where id=?";
            String sql2="update acount set salary=salary+? where id=?";
            //6.执行sql
            pS = conn.prepareStatement(sql);
            pS2 = conn.prepareStatement(sql2);

            pS.setDouble(1,500);
            pS.setString(2,"1");

            pS2.setDouble(1,500);
            pS2.setString(2,"2");
            //7.处理结果
            pS.executeUpdate();
            //该行就算出现异常也会由于使用事务 回滚到执行事务前的状态
            int i=2/0;
            pS2.executeUpdate();

            //提交事务
            conn.commit();
        } catch (SQLException e) {
            try {
                //事务回滚
                if (conn!=null)
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            //8.关闭资源
            JDBCUtils.close(pS,conn);
            JDBCUtils.close(pS2,null);//上面已经关过 避免出错设空

        }

    }
}
