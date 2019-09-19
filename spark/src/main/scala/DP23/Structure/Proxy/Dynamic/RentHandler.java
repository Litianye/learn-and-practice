package DP23.Structure.Proxy.Dynamic;
/**
 * Created by litianye on 2019-08-29
 */


import DP23.Create.Builder.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: learn_and_practice
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-08-29
 **/

public class RentHandler implements InvocationHandler {
    Person landlord;

    public RentHandler(Person landlord) {
        this.landlord = landlord;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(landlord, args);
    }
}
