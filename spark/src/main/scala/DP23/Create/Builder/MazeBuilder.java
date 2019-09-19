package DP23.Create.Builder;
/**
 * Created by litianye on 2019-07-09
 */


import DP23.Create.Product.Maze;

/**
 * @program: spark
 *
 * @description: builder of maze
 *
 * @author: litianye
 *
 * @create: 2019-07-09
 **/

public interface MazeBuilder {
    void BuildMaze();
    void BuildWall();
    void BuildRoom(int roomNo);
    void BuildDoor(int roomFrom, int roomTo);
    Maze GetMaze();
}
