package DP23.Structure.Flyweight;
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

public class ConcreteFlyweight implements Flyweight {
    private Character intrinsicState = null;

    public ConcreteFlyweight(Character intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String state) {

    }
}
