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

public abstract class Person {
    protected Mediator mediator;
    protected String name;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void setMessage(String msg);
    public abstract void getMessage(String msg);
}
