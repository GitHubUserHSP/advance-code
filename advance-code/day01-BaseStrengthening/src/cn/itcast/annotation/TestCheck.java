package cn.itcast.annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*测试框架
当主方法执行后，会自动检测方法（加了Check注解）
* */
public class TestCheck {
	public static void main(String[] args) throws IOException {
		Calculate c=new Calculate();
		Class aClass = c.getClass();

		int num=0;//出现异常的次数
		BufferedWriter bw=new BufferedWriter(new FileWriter("day01-BaseStrengthening\\src\\bug.txt"));

		Method[] method = aClass.getMethods();
		for (Method method1 : method) {
			if (method1.isAnnotationPresent(Check.class)){
				try {
					method1.invoke(c);//把异常捕获 可以把异常信息记录到一个文件中
				} catch (Exception e) {//抛出IllegalAccessException
								//和InvocationTargetException 用Exception一并解决
					num++;
					bw.write(method1.getName()+"出现了异常");
					bw.newLine();//换行
					//区别方法和异常
					//异常的名字
					bw.write("异常的名字："+e.getCause().getClass().getSimpleName());
					bw.newLine();
					//异常的原因
					bw.write("异常的原因:"+e.getCause().getMessage());
					bw.newLine();
					System.out.println("------------");

				}
			}

		}
		bw.write("本次一共出现"+num+"了次异常");
		bw.flush();
		bw.close();
	}

}
