package cn.itcast.test;

import cn.itcast.junit.Calculate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateTest {
    //需要导入junit依赖环境
    //初始化方法：用于资源申请，所有的测试方法在执行前都会先执行
    //Before注解
    @Before
    public void init(){
        System.out.println("init...");
    }
    //释放资源方法：在所有测试方法执行完后，都会执行
    @After
    public void close(){
        System.out.println("close...");
    }



    @Test
    public  void testAdd(){
        Calculate cal=new Calculate();
        int var = cal.add(5, 3);
        System.out.println(var);//直接打印输出只能判断方法中的异常，逻辑错误无法得知
        //断言 断言期望值和实际值一样
        Assert.assertEquals(8,var);
        System.out.println("testAdd...");
    }


    @Test
    public void testSub(){
        System.out.println("testSub...");
        Calculate cal=new Calculate();
        int result = cal.sub(5, 1);
        Assert.assertEquals(5,result);//期望值与实际值不equal时会报红
        // 但是会执行 该方法的第一行会执行 最后一行才报错 即使报错也要执行close释放资源方法 类似于操作流时异常处理的try catch后的finally
    }
}
