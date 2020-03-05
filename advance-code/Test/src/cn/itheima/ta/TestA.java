package cn.itheima.ta;

public class TestA {
    protected  void method(){
        System.out.println("我是爸爸方法");
    }

    public static void main(String[] args) {
        new TestA().method();
    }
}
