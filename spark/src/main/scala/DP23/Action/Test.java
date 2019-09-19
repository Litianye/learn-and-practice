package DP23.Action;
/**
 * Created by litianye on 2019-07-11
 */


import java.util.ArrayList;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-11
 **/

public class Test {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Car car = Car.create(Car::new);
            cars.add(car);
        }
        cars.forEach(Car::showCar);
        Runnable runnable = () -> System.out.println(233);
        runnable.run();
    }

    @FunctionalInterface
    interface Factory<T> {
        T create();
    }

    static class Car {

        public void showCar() {
            System.out.println(this.toString());
        }

        public static Car create(Factory<Car> factory) {
            return factory.create();
        }
    }
}
