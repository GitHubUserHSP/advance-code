import cn.itheima.ta.TestA;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Test {

    public static void main(String[] args) /*throws ClassNotFoundException, SQLException */{


        /*Date date = new Date();
        long time = date.getTime();
        System.out.println(time);//1581863903253 1970年1月1日0:0:0到运行时的ms值

        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
         Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));
        */

        /*
        String s="123";
        int i = Integer.parseInt(s);
        System.out.println(i);

        String str="";
        System.out.println(str.length());
        //        System.out.println();
        System.out.println("");
        String str2=null;
        System.out.println(str2);
        System.out.println(str2!=null);

        //StringBuilder不加Synchronized 效率高 但线程不安全
        StringBuilder sb=new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        sb.append(4);
        System.out.println(sb);

        String s="hello";
        String s1=new String("hello");
        String s3=s1;

        String s4="hello";

        String s2="hel"+"lo";
        System.out.println(s==s4);//true
        */
        /*获取日期的API
        Calendar cal=Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));

        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt.getYear());
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
        System.out.println(LocalDateTime.now().getYear());*/
        /*int[] arr= new int[]{1,5,84,2,64,32};
        System.out.println("冒泡排序前");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){//循环一遍能确定一个最大或最小的，因此少循环一次就行
                if(arr[j]>arr[j+1]){//决定排序是正序 倒序
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("冒泡排序后");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        int[] arr= new int[]{1,5,84,2,64,32};
        System.out.println("选择排序前");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        for(int i=0;i<=arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){//
                if(arr[i]>arr[j]){//
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        System.out.println("选择排序后");
        for (int i : arr) {
            System.out.print(i+" ");
        }*/
        /*已知一个 HashMap<Integer，User>集合， User 有 name（String）和 age（int）属性。
        请写一个方法实现对HashMap 的排序功能，该方法接收 HashMap<Integer，User>为形参，
        返回类型为 HashMap<Integer，User>，要求对 HashMap 中的 User 的 age 倒序进行排序。
        排序时 key=value 键值对不得拆散。
        * */
        /*HashMap<Integer,User> users=new HashMap<>();
        users.put(1,new User("王大",10));
        users.put(2,new User("李二",16));
        users.put(3,new User("张三",12));
        System.out.println(users);

        HashMap<Integer, User> sortHashMap = sortHashMap(users);

        System.out.println(sortHashMap);*/
        //}
    /*private static HashMap<Integer,User> sortHashMap (HashMap<Integer,User> hm){
        //将mapde的键值对存入Set集合
        Set<Map.Entry<Integer, User>> set = hm.entrySet();
        //set集合转换为List集合，为了使用工具类的排序方法
        List<Map.Entry<Integer,User>> list=new ArrayList<>(set);

        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();//倒序
            }
        });
        LinkedHashMap<Integer,User> lhm=new LinkedHashMap<>();

        for(Map.Entry<Integer,User> entry : list){
            lhm.put(entry.getKey(),entry.getValue());
        }
        return lhm;
    }*/

       /* Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql//127.0.0.1:3306/db");
        String sql="update user set age=?  where id=?";
        PreparedStatement pS = conn.prepareStatement(sql);
        pS.setInt(1,23);
        pS.setInt(2,3);
        int i = pS.executeUpdate();
        System.out.println(i);
        pS.close();
        conn.close();*/

       /*TreeSet<Integer> ts=new TreeSet<Integer>();
       TreeSet<Integer> ts1=new TreeSet<Integer>();
       ts.add(1);
       ts.add(3);
       ts.add(5);
       ts.add(35);

        ts1 = (TreeSet) ts.subSet(1, true, 34, true);
        ts.add(23);
        System.out.println(ts+" "+ts1);*/

//       class testA{} //局部内部类 无修饰符

        String name = Test.class.getName();
        System.out.println(name);   //Test

    }
    // private   class teste{   }//成员内部类 修饰符可以是private protected public




}
