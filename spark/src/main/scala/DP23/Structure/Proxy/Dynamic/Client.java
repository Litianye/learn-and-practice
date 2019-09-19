package DP23.Structure.Proxy.Dynamic;
/**
 * Created by litianye on 2019-08-29
 */


import DP23.Create.Builder.Person;

import java.lang.reflect.Proxy;

/**
 * @program: learn_and_practice
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-08-29
 **/

public class Client {

    public static void main(String[] args) {
        Person proxy = (Person) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Person.class},
                new RentHandler(new Person.Builder("test").age(12).money(1233).build()));
        proxy.rent();
    }

}
