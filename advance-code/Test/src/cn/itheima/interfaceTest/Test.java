package cn.itheima.interfaceTest;

public class Test {
    public static void main(String[] args) {
        ITest itt=new ITestImpl();
//        itt.other(); 接口不能调用实现类的其他方法
        itt.test();
    }


}
