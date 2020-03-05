package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ajaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Thread thread=new Thread();
        try {
            thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //可判断是同步还是异步
        */
        //1.获取请求参数
        String username = req.getParameter("username");
        //2.打印
        System.out.println(username);
        //3.响应
        resp.getWriter().write("hello"+username);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
