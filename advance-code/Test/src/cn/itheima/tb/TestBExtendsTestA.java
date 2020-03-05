package cn.itheima.tb;

import cn.itheima.ta.TestA;

public class TestBExtendsTestA extends TestA {
    public static void main(String[] args) {
//        new TestA().method(); //只能子类对象，访问继承其父类的方法

        TestBExtendsTestA testA = new TestBExtendsTestA();
        testA.method();


    }
    public void TestBExtendsTestA(){
        super.method();
    }

//    @Override
//    protected void method() {
//        System.out.println("我是儿子方法");
//    }
}
