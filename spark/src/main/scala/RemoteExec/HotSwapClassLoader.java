package RemoteExec;
/**
 * Created by litianye on 2019-06-19
 */


/**
 * @program: spark
 *
 * @description: 为了多次加载执行类而加入的加载器
 *
 * @author: litianye
 *
 * @create: 2019-06-19
 **/

public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}