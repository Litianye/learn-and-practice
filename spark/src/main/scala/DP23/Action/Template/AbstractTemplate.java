package DP23.Action.Template;
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

public abstract class AbstractTemplate {
    public void templateMethod() {
        abstractMethod();
        hookMethod();
        concreteMethod();
    }

    protected abstract void abstractMethod();
    protected void hookMethod(){}
    private final void concreteMethod(){}
}
