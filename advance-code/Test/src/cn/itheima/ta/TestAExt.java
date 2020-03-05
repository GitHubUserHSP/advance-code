package cn.itheima.ta;

public class TestAExt extends TestA {
    public static void main(String[] args) {
        /*TestA testA = new TestA();
        testA.method();*/
        TestA testA=new TestAExt();//多态
        testA.method();


    }
}
