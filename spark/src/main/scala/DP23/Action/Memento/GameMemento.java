package DP23.Action.Memento;
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

public class GameMemento {
    private int palyerSteps;

    public int getPalyerSteps() {
        return palyerSteps;
    }

    public GameMemento(int playerSteps) {
        this.palyerSteps = playerSteps;
    }
}
