package DP23.Create.Singleton;
/**
 * Created by litianye on 2019-07-09
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-09
 **/

public class Single1 {
    private static Single1 Instance;
    private Single1() {}

    public static synchronized Single1 getInstance() {
        if (Instance == null) {
            Instance = new Single1();
        }
        return Instance;
    }
}
