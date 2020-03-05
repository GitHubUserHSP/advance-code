package cn.itcast.web.servlet;
//使用BeanUtils优化
import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        /*//2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.封装user对象
        User loginUser=new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/
        //获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        User loginUser=new User();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用UserDao的login的方法
        UserDao userDao=new UserDao();
        User user = userDao.login(loginUser);
        //5.判断user
        if(user==null){
            //登录失败
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            //登录成功
            //存储数据
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }

    }
}
