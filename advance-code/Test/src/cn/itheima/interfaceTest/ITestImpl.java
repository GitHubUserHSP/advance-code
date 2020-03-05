package cn.itheima.interfaceTest;

public class ITestImpl implements ITest {
    @Override
    public void test() {
        System.out.println("test实现类方法执行");
    }
    public void other(){
        System.out.println("子类其他方法执行");
    }
}
