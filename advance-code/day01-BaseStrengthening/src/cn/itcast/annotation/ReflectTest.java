package cn.itcast.annotation;
//使用注解解析省略配置过程的框架类

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Pro(className="cn.itcast.annotation.Demo2",methodName="show")//在此处修改className和methodName等同与配置文件那两处刘垓
public class ReflectTest {
	public static void main(String[] args) throws Exception {
		/*前提：不能改变该类的任何代码，可以创建任意类的对象，可以执行任意的方法
		 * */
		//1.解析注解
		//1.1获取该类的字节码文件对象
		Class<ReflectTest> reflectTestClass = ReflectTest.class;
		//2.获取上面的注解对象
		//其实就是在内存中生成了一个该注解接口的子类实现对象
		/*public class ProImpl implements Pro{
			public String className(){ return "cn.itcast.annotation.Demo1";}
			public String methodName(){ return "show";}
		}

		*/
		Pro an = reflectTestClass.getAnnotation(Pro.class);
		//3.调用注解对象中定义的抽象方法，获取返回值
		String s = an.className();
		System.out.println(s);
		String s1 = an.methodName();
		System.out.println(s1);
		//4.类加载进内存
		Class<?> aClass = Class.forName(s);
		//5.创建对象
		Object o = aClass.newInstance();
		//6.获取方法对象
		Method method = aClass.getMethod(s1);
		//method.getAnnotation();//方法也能获取对象
		//7.执行方法
		method.invoke(o);
	}
}
