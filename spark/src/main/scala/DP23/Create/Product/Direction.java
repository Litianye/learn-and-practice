package DP23.Create.Product;
/**
 * Created by litianye on 2019-07-08
 */


import lombok.Getter;
import lombok.Setter;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-08
 **/

public enum Direction {
    NORTH(0),
    SOUTH(1),
    EAST(2),
    WEST(3);

    private int value;
    public int getValue() {
        return this.value;
    }

    Direction(int value) {
        this.value = value;
    }

    public static Direction valueOf(int value) {
        switch (value) {
            case 0:
                return NORTH;
            case 1:
                return SOUTH;
            case 2:
                return EAST;
            case 3:
                return WEST;
            default:
                throw new IllegalArgumentException("Unsupported value: " + value);
        }
    }
}
