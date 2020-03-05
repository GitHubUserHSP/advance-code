<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: hp-pc
  Date: 2019/12/4
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
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
                    value= URLDecoder.decode(formatedTime, "utf-8");
                    System.out.println("解码后"+value);
                    //response.getWriter().write("<h2>欢迎回来，您上次的访问时间为"+value+"</h2>");//不建议使用这种方式
                    //因为response总是先于out输出该方法会影响排版
    %>
                    <h2>欢迎回来，您上次的访问时间为<%=value%></h2>
    <%

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
    %>
            <h2>欢迎您首次访问</h2>
    <%
        }
    %>

</body>
</html>
