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

public class CareTaker {
    private GameMemento gameMemento;
    public GameMemento retrieveMemento() {
        return this.gameMemento;
    }

    public void saveMemeto(GameMemento gameMemento) {
        this.gameMemento = gameMemento;
    }
}
