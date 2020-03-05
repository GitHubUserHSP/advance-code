package cn.itcast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*描述需要执行的类名和方法名*/
//当属性名为value时，value可以省略，当数组中只有一行时，可以省略{}
@Target(value={ElementType.TYPE})//ElementType.TYPE 作用在类上
@Retention(RetentionPolicy.RUNTIME)//被保留在runtime阶段
public @interface Pro {
    String className();//实际上就是抽象方法 起名为属性
    String methodName();
}
