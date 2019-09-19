package JVM;
/**
 * Created by litianye on 2019-06-19
 */


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-06-19
 **/

public class DyProxy {
    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("Hello, World!");
        }
    }

    static class DynamicProxy implements InvocationHandler {
        Object object;

        Object bind(Object oriObject) {
            this.object = oriObject;
            return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                    object.getClass().getInterfaces(),
                    this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Wow!");
            return method.invoke(object, args);
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }
}
