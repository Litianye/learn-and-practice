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
 * @description: AbstractFactory
 *
 * @author: litianye
 *
 * @create: 2019-07-08
 **/

public class CommonMazeFactory implements MazeFactory{
    public CommonMazeFactory() {}

    @Override
    public Maze MakeMaze() {
        return new Maze();
    }

    @Override
    public Wall MakeWall() {
        return new Wall();
    }

    @Override
    public Room MakeRoom(int roomNo) {
        return new Room(roomNo);
    }

    @Override
    public Door MakeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
