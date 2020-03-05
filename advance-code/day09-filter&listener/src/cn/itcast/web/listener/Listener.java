package cn.itcast.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;


//@WebListener //web.xml两种配置二选一
public class Listener implements ServletContextListener {
    /*
    监听ServletContext对象创建的，ServletContext对象在服务器启动后自动创建
    * */
    //一般通过ServletContext加载的资源文件是全局资源文件 整个项目要用的
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载资源文件
        //1.获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();
        //2.加载资源文件 不能写死
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //System.out.println(contextConfigLocation);
        //3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
       // System.out.println(realPath);
        //4.关联流 加载进内存
        try{
            FileInputStream fis=new FileInputStream(realPath);
            System.out.println(fis);//流能被打印到控制台 证明资源文件被加载成功
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了");
    }
    //ServletContext对象在服务器正常关闭后后自动销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了");

    }
}
