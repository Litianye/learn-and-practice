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

public class Game {
    private int playerSteps;

    public GameMemento createGameMemento() {
        return new GameMemento(playerSteps);
    }

    public void play() {
        playerSteps = 0;
    }

    public void restore(GameMemento gameMemento) {
        this.playerSteps = gameMemento.getPalyerSteps();
    }
}
