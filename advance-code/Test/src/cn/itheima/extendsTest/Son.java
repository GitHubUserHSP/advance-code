package cn.itheima.extendsTest;

public class Son extends Dad {
    @Override
    void dadMethod(){
        System.out.println("父类方法重写");
    }

    void sonMethod(String s){
        System.out.println("父类方法重写");
    }
}
