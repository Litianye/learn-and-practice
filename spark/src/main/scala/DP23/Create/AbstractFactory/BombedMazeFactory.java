package DP23.Create.AbstractFactory;
/**
 * Created by litianye on 2019-07-08
 */


import DP23.Create.Product.Door;
import DP23.Create.Product.Maze;
import DP23.Create.Product.Room;
import DP23.Create.Product.Wall;

/**
 * @program: spark
 *
 * @description: another type of maze factory
 *
 * @author: litianye
 *
 * @create: 2019-07-08
 **/

public class BombedMazeFactory implements MazeFactory {

    @Override
    public Maze MakeMaze() {
        return null;
    }

    @Override
    public Wall MakeWall() {
        return null;
    }

    @Override
    public Room MakeRoom(int roomNo) {
        return null;
    }

    @Override
    public Door MakeDoor(Room r1, Room r2) {
        return null;
    }
}
