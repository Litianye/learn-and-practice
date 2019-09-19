package DP23.Action.Visitor;
/**
 * Created by litianye on 2019-07-16
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-16
 **/

public abstract class Node {
    public abstract void accept(Visitor visitor);
}
