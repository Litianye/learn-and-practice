package DP23.Create.AbstractFactory;

import DP23.Create.Product.Door;
import DP23.Create.Product.Maze;
import DP23.Create.Product.Room;
import DP23.Create.Product.Wall;

/**
 * Created by litianye on 2019-07-08
 */

public interface MazeFactory {
    Maze MakeMaze();

    Wall MakeWall();

    Room MakeRoom(int roomNo);

    Door MakeDoor(Room r1, Room r2);
}
