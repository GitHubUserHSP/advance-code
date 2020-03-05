package cn.itcast.jdbctemplate;

import cn.itcast.domain.Account;
import cn.itcast.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplateJunit {
    //由于每次执行DML或DQL语句都需要创建template对象 当成成员变量声明共同使用
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    //DML 增删改类似 写一个示范
    @Test
    public void test(){//Junit不需main方法 加上@Test注解 把Junit加入到类路径即可
        //1.定义sql       //测试的方法遵循public void 无参 方法名必须test开头
        String sql="update account set balance=3 where id=6";
        int line = template.update(sql);
        System.out.println(line);//一般用Junit测试不会打印输出结果 只看报红还是报绿
    }
    //DQL
    //查询id为1的记录封装到Map集合中
    @Test
    public void test2(){
        String sql="select * from account where id=?";
        //查询的结果集长度只能是1，查询两条放入Map集合会报错
        Map<String, Object> map = template.queryForMap(sql, 1);//把数据库表中的属性当键，一条元组（记录）的
                                                                // 对应值为键值对的值
        System.out.println(map);
    }
    //查询所有记录封装到List集合中
    @Test
    public void test3(){
        String sql="select * from account";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);
    }
    //查询所有记录，将其封装为account对象的List集合 自己实现RowMapper接口达不到简化的效果
    @Test
    public void test4(){
        String sql="select * from account";
        List<Account> query = template.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int i) throws SQLException {
                Account account = new Account();

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");

                account.setId(id);
                account.setName(name);
                account.setBalance(balance);
                return account;
            }
        });//RowMapper接口匿名内部类写法
        for (Account account : query) {
            System.out.println(account);
        }
    }
    //简化上面方法
    @Test
    public void test5(){
        String sql="select * from account";
        List<Account> list = template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : list) {
            System.out.println(account);

        }

    }
    //查询总记录数
    @Test
    public void test6(){
        String sql="select count(id) from account";
        Long l = template.queryForObject(sql, Long.class);
        System.out.println(l);
    }
}
