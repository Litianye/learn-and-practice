package DP23.Create.Builder;
/**
 * Created by litianye on 2019-07-09
 */


import DP23.Create.Product.Direction;
import DP23.Create.Product.Maze;
import DP23.Create.Product.Room;

/**
 * @program: spark
 *
 * @description: simple implement of maze builder
 *
 * @author: litianye
 *
 * @create: 2019-07-09
 **/

public class StandardMazeBuilder implements MazeBuilder {
    private Maze currentMaze;

    public StandardMazeBuilder(){
        currentMaze = new Maze();
    }

    @Override
    public void BuildMaze() {

    }

    @Override
    public void BuildWall() {

    }

    @Override
    public void BuildRoom(int roomNo) {

    }

    @Override
    public void BuildDoor(int roomFrom, int roomTo) {

    }

    @Override
    public Maze GetMaze() {
        return null;
    }
}
