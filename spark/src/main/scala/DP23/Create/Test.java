package DP23.Create;
/**
 * Created by litianye on 2019-07-08
 */


import DP23.Create.AbstractFactory.CommonMazeFactory;
import DP23.Create.AbstractFactory.EnchantedMazeFactory;
import DP23.Create.Builder.Person;
import DP23.Create.Product.*;
import DP23.Create.Singleton.SingleInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-08
 **/

public class Test {
    public static void main(String[] args) {
//        System.out.println(createMaze().RoomNo(1));
//        System.out.println(createMaze().RoomNo(2));
    }

    private Maze createMaze(EnchantedMazeFactory factory) {
        List<? extends Person> people = new ArrayList<>(); //Person及子类，无法放
        List<? super Person> humans = new ArrayList<>(); //Person及父类，只能取Object

        Maze maze = factory.MakeMaze();
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Door theDoor = new Door(r1, r2);

        maze.AddRoome(r1);
        maze.AddRoome(r2);

        r1.setSide(Direction.NORTH, new Wall());
        r1.setSide(Direction.EAST, theDoor);
        r1.setSide(Direction.SOUTH, new Wall());
        r1.setSide(Direction.WEST, new Wall());

        r2.setSide(Direction.NORTH, new Wall());
        r2.setSide(Direction.EAST, new Wall());
        r2.setSide(Direction.SOUTH, new Wall());
        r2.setSide(Direction.WEST, theDoor);


        Person person = new Person.Builder("test").age(12).money(1233).build();

        return maze;

    }
}
