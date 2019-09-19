package dataapp;
/**
 * Created by litianye on 2019-06-20
 */


import java.lang.reflect.Method;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-06-20
 **/

public class TestMyAnno {
    @MyAnno(value = "233")
    public void doSth() {
        System.out.println("my anno");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = TestMyAnno.class.getMethod("doSth", null);
        if (method.isAnnotationPresent(MyAnno.class)) {
            MyAnno myAnno = method.getAnnotation(MyAnno.class);
            System.out.println(myAnno.value());
        }
    }
}
