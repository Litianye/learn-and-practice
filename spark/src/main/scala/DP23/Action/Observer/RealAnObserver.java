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

public class RealAnObserver implements MyObserver {
    private String name;

    public RealAnObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message, String subjectName) {

    }
}
