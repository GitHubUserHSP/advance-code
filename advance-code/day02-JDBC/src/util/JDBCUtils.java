package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//JDBC工具类
public class JDBCUtils {
	//文件的读取只读一次，随类加载，且只加载一次 静态代码块解决
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	static{
		try {
			Properties pro=new Properties();
			//获取src路径下的文件的方式--->Class Loader类加载器

			/*ClassLoader classLoader = JDBCUtils.class.getClassLoader();
			URL resource = classLoader.getResource("jdbc.properties");
			String path = resource.getPath();*/

			URL resource = JDBCUtils.class.getClassLoader().getResource("jdbc.properties");
			String path = resource.getPath();

			//pro.load(new FileReader("D:\\IdeaProjects\\advance-code\\day02-JDBC\\src\\jdbc.properties"));
			pro.load(new FileReader(path));

			url = pro.getProperty("url");
			username=pro.getProperty("username");
			password=pro.getProperty("password");
			driver = pro.getProperty("driver");
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//获取连接
	//为了使方法通用 getConnection，方法既不能写死,既不能使用传参解决，通过配置文件解决见22行
	public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, username, password);
	}
	//释放资源两种情况，重载方法解决，静态有利于类名.方法名调用
	public static void close(Statement st,Connection conn ){
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	public static void close(ResultSet rs,Statement st,Connection conn ){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
