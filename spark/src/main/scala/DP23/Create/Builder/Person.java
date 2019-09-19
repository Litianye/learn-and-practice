package DP23.Create.Builder;
/**
 * Created by litianye on 2019-07-09
 */


import java.util.Random;

/**
 * @program: spark
 *
 * @description: Simple type of Builder
 *
 * @author: litianye
 *
 * @create: 2019-07-09
 **/

public class Person {
    private final String name;
    private final int age;
    private final double money;

    public Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        money = builder.money;
    }

    public static class Builder {
        private final String name;
        private int age;
        private double money;

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder money(int money) {
            this.money = money;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private Random random = new Random();
    public int rent() {
        return random.nextInt();
    }
}
