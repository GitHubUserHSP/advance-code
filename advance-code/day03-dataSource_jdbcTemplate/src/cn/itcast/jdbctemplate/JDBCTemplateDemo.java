package cn.itcast.jdbctemplate;

import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/*Spring JDBC：Spring框架对jdbc的简单的封装，提供一个JdbcTemplate对象简化JDBC的开发
* */
public class JDBCTemplateDemo {
    public static void main(String[] args) {
        //1.导包
        //2.1 创建DataSource对象
        DataSource ds = JDBCUtils.getDataSource();
        // 2.2 创建JDBCTemplate对象
        JdbcTemplate template=new JdbcTemplate(ds);//参数需要传入DataSource ds
        String sql="update account set balance=10 where id=?";
        int i = template.update(sql, 6);
        System.out.println(i);
        //在这里不需要申请连接和不需要释放资源，自动把用完的连接归还到连接池

    }
}
