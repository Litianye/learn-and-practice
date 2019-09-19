package DP23.Structure.Decorator;
/**
 * Created by litianye on 2019-07-10
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-10
 **/

public abstract class Berverage {
    String description = "unknown coffee";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
