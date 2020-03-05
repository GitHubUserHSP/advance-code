package cn.itcast.junit;

/*之前的测试 由于主方法只能有一个 测试两个方法时通常要注释另一个
并且由于通常测试类和类都是一个包下不便于管理
 * */
public class Test {
    public static void main(String[] args) {

        Calculate cal=new Calculate();
        int var1 = cal.add(10, 20);
        System.out.println(var1);

        System.out.println(cal.sub(3,2));
    }
}
