package DP23.Create.Product;
/**
 * Created by litianye on 2019-07-08
 */


import java.util.HashMap;
import java.util.Map;

/**
 * @program: spark
 *
 * @description: set of room
 *
 * @author: litianye
 *
 * @create: 2019-07-08
 **/

public class Maze {
    private Map<Integer, Room> rooms = new HashMap();

    public Maze() {}

    public void AddRoome(Room room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public Room RoomNo(int roomNo) {
        return rooms.get(roomNo);
    }
}
