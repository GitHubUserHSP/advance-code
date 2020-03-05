package cn.itcast.jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*练习 通过用户键盘输入用户名和密码，判断用户登录成功与否*/
public class JDBCDemoLogin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String line1 = sc.nextLine();
        System.out.println("请输入密码");
        String line2 =sc.nextLine();
        boolean result =new JDBCDemoLogin().login(line1, line2);//方法为静态方法可通过类名.对象名 否则创建对象调用
        if(result){
            System.out.println("登陆成功");
        }
        else System.out.println("用户名或密码错误");
    }
    public  boolean login(String  username,String password){
        if(username==null||password==null){
            return false;
        }
        ResultSet resultSet=null;
        Statement statement=null;
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection();
            statement = conn.createStatement();
            String sql="select * from user where username='"+username+"' and password='"+password+"' ";
            resultSet = statement.executeQuery(sql);
            //由于只需要判断结果集对象里面是否有数据即可判断匹配成功与否，不需要取出，所有判断即可
            /*if (resultSet.next()){
                return true;
            }else return false;*/
            return resultSet.next();//由于结果集的next方法返回值是boolean，简化书写
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.close(resultSet,statement,conn);
        }
        return false;
    }

}
