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

public class Room extends MapSite{
    private int roomNumber;
    public int getRoomNumber() {
        return this.roomNumber;
    }

    public Room(int roomNo) {
        this.roomNumber = roomNo;
    }

    @Override
    void Enter() {}

    private MapSite[] sides = new MapSite[4];

    public MapSite getSide(Direction direction) {
        return sides[direction.getValue()];
    }

    public void setSide(Direction direction, MapSite site) {
        sides[direction.getValue()] = site;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append(roomNumber).append(" ");
        for (int i=0; i<4; i++) {
            stringBuilder.append(Direction.valueOf(i)).append(":")
                    .append(sides[i].getClass().getSimpleName()).append(";");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
