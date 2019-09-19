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

public class Single2 {
    private static Single2 Instance;
    private Single2() {}

    public static Single2 getInstance() {
        if (Instance == null) {
            synchronized (Single2.class) {
                if (Instance == null) {
                    Instance = new Single2();
                }
            }
        }
        return Instance;
    }
}
