package cn.itheima.ui;

import cn.itheima.serivice.IService;
import cn.itheima.serivice.ServiceImpl;

public class Client {
    public static void main(String[] args) {
        IService iService=new ServiceImpl();
        iService.saveService();
    }
}
