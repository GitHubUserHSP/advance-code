package cn.itheima.serivice;

import cn.itheima.dao.DaoImpl;
import cn.itheima.dao.IDao;

public class ServiceImpl implements IService {
    @Override
    public void saveService() {
        IDao dao=new DaoImpl();
        dao.saveDao();
    }
}
