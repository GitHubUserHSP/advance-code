package cn.itheima.extendsTest;

public class Test {
    public static void main(String[] args) {
        Dad dad=new Dad();
        dad.dadMethod();

        System.out.println("====");
        Dad dad1=new Son();
        dad1.dadMethod();

        System.out.println("============");

    }
}
