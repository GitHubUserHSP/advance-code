package cn.itcast.reflect;
//框架类

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
//@SuppressWarnings(value={"All"})
public class ReflectTest {
	//throws的异常可以为了省事，只抛出Exception
	public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		/*可以创建任意类的对象，可以执行任意的方法
		 * 前提：不能改变该类的任何代码，可以创建任意类的对象，可以执行任意的方法
		 * */
		//1.加载配置文件
		//1.1创建Properties对象
		Properties pro=new Properties();
		//1.2加载配置文件，转换为一个集合
		//1.2.1获取class目录下的配置文件
		ClassLoader classLoader = ReflectTest.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("pro.properties");
		pro.load(is);
		//2.获取文件中定义的数据
		String classname = pro.getProperty("className");
		String methodname = pro.getProperty("methodName");
		//3.加载该类进内存
		Class cls = Class.forName(classname);
		//4.创建对象
		Object obj = cls.newInstance();
		//5.获取方法对象
		Method methodName1 = cls.getMethod(methodname);
		//6.方法执行
		Object invoke = methodName1.invoke(obj);


	}
}
