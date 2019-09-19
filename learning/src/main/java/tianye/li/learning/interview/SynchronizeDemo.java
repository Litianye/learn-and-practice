package tianye.li.learning.interview;
/**
 * Created by litianye on 2019-08-21
 */


/**
 * @program: learn_and_practice
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-08-21
 **/

public class SynchronizeDemo implements Runnable {
    private static int count = 0;

//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new SynchronizeDemo());
//            thread.start();
//        }
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("result: " + count);
//    }

    @Override
    public void run() {
        synchronized (SynchronizeDemo.class) {
            for (int i = 0; i < 1000000; i++)
                count++;
        }
    }

    private static void method() {
    }

    private static volatile boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) ;
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }

    private int a = 0;
    private volatile boolean flag = false;
    public void writer(){
        a = 1;          //1
        flag = true;   //2
    }
    public void reader(){
        if(flag){      //3
            int i = a; //4
        }
    }
}