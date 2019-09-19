package DP23.Create.Prototype;
/**
 * Created by litianye on 2019-07-09
 */


import DP23.Create.Product.Maze;

import java.io.Serializable;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-09
 **/

public class MazePrototype implements Cloneable, Serializable {
    private static final long serialVersionID = 2L;
    private Maze currentMaze;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
