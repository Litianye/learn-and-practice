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

public class NodeB extends Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA(){
        return "B";
    }
}
