package DP23.Create.Product;
/**
 * Created by litianye on 2019-07-08
 */


/**
 * @program: spark
 *
 * @description: one kind of MapSite
 *
 * @author: litianye
 *
 * @create: 2019-07-08
 **/

public class Door extends MapSite {
    private boolean isOpen = false;
    private Room room_1;
    private Room room_2;

    public Door(Room room_1, Room room_2){
        this.room_1 = room_1;
        this.room_2 = room_2;
    }

    @Override
    void Enter() {}

    public Room otherSideRoom(Room room) {
        if (room.equals(room_1)) {
            return room_2;
        }else if (room.equals(room_2)) {
            return room_1;
        }else {
            return null;
        }
    }
}
