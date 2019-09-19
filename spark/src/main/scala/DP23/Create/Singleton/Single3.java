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

public class Single3 {
    private static volatile Single3 Instance;
    private Single3() {}

    public static Single3 getInstance() {
        if (Instance == null) {
            synchronized (Single3.class) {
                if (Instance == null) {
                    Instance = new Single3();
                }
            }
        }
        return Instance;
    }
}
