package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*利用cookie实现登录常见的 欢迎访问
* */
@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag=true;
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)){
                    flag=true;
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String formatedTime = sdf.format(date);
                    System.out.println("编码前"+formatedTime);
                   //URL编码
                    formatedTime= URLEncoder.encode(formatedTime, "utf-8");
                    System.out.println("编码后"+formatedTime);
                    cookie.setValue(formatedTime);
                    //发送前设置存活时间一个月
                    cookie.setMaxAge(30*24*60*60);
                    response.addCookie(cookie);
                    //响应数据前获取时间 由于中文的存在响应前（最上面）要设置消息体的响应格式
                    String value = cookie.getValue();
                    System.out.println("解码前"+value);
                    //URl解码
                    value=URLDecoder.decode(formatedTime, "utf-8");
                    System.out.println("解码后"+value);
                    response.getWriter().write("<h2>欢迎回来，您上次的访问时间为"+value+"</h2>");
                    break;
                }
            }
        }
        if(cookies==null||cookies.length==0||flag==false){
            //没有第一次访问
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String format = sdf.format(date);
            System.out.println("编码前"+format);
            URLEncoder.encode(format,"utf-8");
            System.out.println("编码后"+format);

            Cookie cookie=new Cookie("lastTime",format) ;
            cookie.setValue(format);
            cookie.setMaxAge(30*24*60*60);
            response.addCookie(cookie);
            response.getWriter().write("欢迎您首次访问");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
