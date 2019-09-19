package RemoteExec;
/**
 * Created by litianye on 2019-06-19
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @program: spark
 *
 * @description: JavaClass执行工具
 *
 * @author: litianye
 *
 * @create: 2019-06-19
 **/

public class JavaClassExecuter {
    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "RemoteExec/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[] {String.class});
            method.invoke(null, new String[] {null});
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return HackSystem.getBufferString();
    }

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("/Users/litianye/IdeaProjects/learn_and_practice/spark/src/main/scala/JVM/DyProxy.class");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
        System.out.println(JavaClassExecuter.execute(b));
    }
}
