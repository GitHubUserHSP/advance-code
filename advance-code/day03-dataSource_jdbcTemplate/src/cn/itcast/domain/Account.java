package cn.itcast.domain;

public class Account {
    private int id;
    private String name;
    private double balance;
    //private  Double b=null;基本数据类型的默认值不能为null,包装类可以

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public double getBalance() {return balance;}
    public void setBalance(double balance) {this.balance = balance;}

    public Account() {
    }
    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
