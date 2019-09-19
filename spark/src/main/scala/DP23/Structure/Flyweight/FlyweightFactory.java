package DP23.Structure.Flyweight;
/**
 * Created by litianye on 2019-07-10
 */


import java.util.HashMap;
import java.util.Map;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-10
 **/

public class FlyweightFactory {
    private Map<Character, Flyweight> files = new HashMap<>();

    public Flyweight factory(Character state) {
        Flyweight fly = files.get(state);
        if (fly == null) {
            fly = new ConcreteFlyweight(state);
            files.put(state, fly);
        }
        return fly;
    }
}
