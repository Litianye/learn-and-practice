package DP23.Action.Observer;
/**
 * Created by litianye on 2019-07-15
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-15
 **/

public class RealSubject implements MySubject {
    private String subjectName = "OH";

    private List<MyObserver> list;
    public RealSubject(){
        list = new ArrayList<MyObserver>();
    }

    @Override
    public void addObserver(MyObserver myObserver) {
        list.add(myObserver);
    }

    @Override
    public void deleteObserver(MyObserver myObserver) {
        list.remove(myObserver);
    }

    @Override
    public void notifyObserver(String message) {
        for (MyObserver observer: list) {
            observer.update(message, subjectName);
        }
    }
}
