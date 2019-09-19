package tianye.li.learning.interview;
/**
 * Created by litianye on 2019-08-01
 */


import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.Semaphore;


/**
 * @program: learn_and_practice
 *
 * @description: 878
 *
 * @author: litianye
 *
 * @create: 2019-08-01
 **/


public class NthMagicNumber {

    private Object lock = new Object();

    public static void main(String[] args) {
    }

    public static long maxCommonFactor(long A, long B) {
        long min = Math.min(A, B);
        long max = Math.max(A, B);
        long temp = -1;
        while (temp != 0) {
            temp = max % min;
            max = min;
            min = temp;
        }
        return A*B/max;
    }

    public static int minComMul(int x, int y) {
        int result = y;
        int tmp = x%y;
        while (tmp != 0) {
            tmp = result%tmp;
            result = tmp;
        }
        return y;
    }
}
