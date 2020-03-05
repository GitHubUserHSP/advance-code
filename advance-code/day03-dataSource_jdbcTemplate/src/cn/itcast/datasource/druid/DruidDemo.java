package cn.itcast.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件Properties
        Properties pro=new Properties();
        //通过该类的名字获取类加载器
        InputStream resourceAsStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");//返回值刚好是is
        pro.load(resourceAsStream);//参数为IuputStream,通过上行的is把name下的配置文件的属性名和属性值加载到内存放到Properties集合中
        //4.获取数据库连接对象
        DruidDataSourceFactory ddsf=new DruidDataSourceFactory();

        //5.获取连接
        DataSource ds = ddsf.createDataSource(pro);
        Connection conn = ds.getConnection();

    }
}
