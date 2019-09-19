package DP23.Action.Observer;
/**
 * Created by litianye on 2019-07-15
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-15
 **/

public interface MySubject {
    void addObserver(MyObserver myObserver);
    void deleteObserver(MyObserver myObserver);
    void notifyObserver(String message);
}
