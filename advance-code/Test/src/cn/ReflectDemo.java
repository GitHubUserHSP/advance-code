package cn;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Properties pro=new Properties();    //加载配置文件
        ClassLoader cl = ReflectDemo.class.getClassLoader();    //获取class类不加载进内存 isStream会为空


        InputStream is = cl.getResourceAsStream("config.properties");

        pro.load(is);

        String realclassName = pro.getProperty("className");    //键找值
        String realmethodName = pro.getProperty("methodName");

        Class aClass = Class.forName(realclassName);//通过全类名获取class对象(包括加载进内存)


        Object o = aClass.newInstance();    //通过class对象实例一个对象

        Method method = aClass.getMethod(realmethodName);

        method.invoke(o);   //执行方法
    }

}
