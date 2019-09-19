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

public class Single {
    private static Single Instance;
    private Single() {}

    public static Single getInstance() {
        if (Instance == null) {
            Instance = new Single();
        }
        return Instance;
    }
}
