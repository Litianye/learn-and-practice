package tianye.learn.practice.base;/**
 * Created by litianye on 2019-04-01
 */


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: learn_and_practice
 *
 * @description: dp practice
 *
 * @author: litianye
 *
 * @create: 2019-04-01
 **/

public class DP {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0 || array==null) {
            return 0;
        }
        int curSum=0;
        int greatestSum=0x80000000;
        for (int i = 0; i < array.length; i++) {
            if (curSum<=0) {
                curSum=array[i]; //记录当前最大值
            }else {
                curSum+=array[i]; //当array[i]为正数时，加上之前的最大值并更新最大值。
            }
            System.out.println(curSum);
            if (curSum>greatestSum) {
                greatestSum=curSum;
            }
        }
        return greatestSum;
    }
}
