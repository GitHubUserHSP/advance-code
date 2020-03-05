package cn.itcast.jdbc;

import util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/*用Papared*/
public class JDBCLoginEnd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String line1 = sc.nextLine();
        System.out.println("请输入密码");
        String line2 =sc.nextLine();
        boolean result =new JDBCLoginEnd().login(line1, line2);//方法为静态方法可通过类名.对象名 否则创建对象调用
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
        PreparedStatement preparedStatement=null;
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="select * from user where username=? and password=? ";//使用占位符，后面使用前记得赋值
            // statement = conn.createStatement();//老方法
            //resultSet = statement.executeQuery(sql);
            preparedStatement = conn.prepareStatement(sql);
            //给占位符？赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            //由于只需要判断结果集对象里面是否有数据即可判断匹配成功与否，不需要取出，所有判断即可
            /*if (resultSet.next()){
                return true;
            }else return false;*/
            return resultSet.next();//由于结果集的next方法返回值是boolean，简化书写
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.close(resultSet,preparedStatement,conn);
        }
        return false;
    }

}
