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

public class Single4 {
    private static final Single4 INSTANCE = new Single4();
    private Single4() {}
    public static Single4 getInstance() {
        return INSTANCE;
    }
}
