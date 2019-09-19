package DP23.Action.Mediator;
/**
 * Created by litianye on 2019-07-12
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-12
 **/

public class Landlord extends Person {
    public Landlord(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void setMessage(String msg) {
        mediator.operation(this, msg);
    }

    @Override
    public void getMessage(String msg) {

    }
}
