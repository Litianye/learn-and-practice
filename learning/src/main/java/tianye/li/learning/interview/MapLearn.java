package tianye.li.learning.interview;
/**
 * Created by litianye on 2019-08-27
 */


import javafx.util.Pair;
import lombok.var;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @program: learn_and_practice
 *
 * @description: map learning
 *
 * @author: litianye
 *
 * @create: 2019-08-27
 **/

public class MapLearn {
    static class Game{}
    static class Movie{}

    static class Father {
        public void choice(Game game) {
            System.out.println("father choice game");
        }

        public void choice(Movie movie) {
            System.out.println("father choice movie");
        }
    }

    static class Son extends Father {
        public void choice(Game game) {
            System.out.println("son choice game");
        }

        public void choice(Movie movie) {
            System.out.println("son choice movie");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Father father = new Father();
        Father son = new Son();
        father.choice(new Game());
        son.choice(new Movie());
    }

    private static <K, V, P> void test(K key, V val, P per) {

    }

    class Test<K,V,P> {
        private K key;
        private V value;
        private P priority;

        public Test(K key, V value, P priority) {
            this.key = key;
            this.value = value;
            this.priority = priority;
        }
    }


    public static void getParamType() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyThread myThread = new MyThread();
        Method method = MyThread.class.getMethod("reflectTest", Object.class, Object.class);
        System.out.println(method.invoke(myThread,"test", "233"));
        Type[] types = method.getGenericParameterTypes();
        System.out.println(types[0]);
        //参数化的类型
        ParameterizedType pType  = (ParameterizedType)types[0];
        //原始类型
        System.out.println(pType.getRawType());
        //实际类型参数
        System.out.println(pType.getActualTypeArguments()[0]);
        System.out.println(pType.getActualTypeArguments()[1]);
    }
}
