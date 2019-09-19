package DP23.Create.FactoryMethod;
/**
 * Created by litianye on 2019-07-09
 */


import DP23.Create.Product.Maze;

/**
 * @program: spark
 *
 * @description: Factory of maze game
 *
 * @author: litianye
 *
 * @create: 2019-07-09
 **/

public interface MazeGame {
    Maze MakeMaze();
}
