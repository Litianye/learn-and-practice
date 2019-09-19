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

public class DarkRoast extends Berverage {
    public DarkRoast() {
        description = "dark roast";
    }

    @Override
    public double cost() {
        return 10.0;
    }
}
