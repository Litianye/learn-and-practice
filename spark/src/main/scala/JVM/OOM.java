package JVM;
/**
 * Created by litianye on 2019-05-28
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @program: spark
 *
 * @description: out of memory
 *
 * @author: litianye
 *
 * @create: 2019-05-28
 **/

public class OOM {
    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
