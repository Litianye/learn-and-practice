package DP23.Structure.Proxy;
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

public class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void visit() {

    }
}
