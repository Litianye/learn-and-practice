package tianye.li.learning.interview;
/**
 * Created by litianye on 2019-08-21
 */


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learn_and_practice
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-08-21
 **/

public class FinalDemo {

    static class NumberWrapper {
        public int value = 0;
    }

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition comCondition = lock.newCondition();
        NumberWrapper numberWrapper = new NumberWrapper();

        Thread threadA = new Thread() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("i am threadA! "+System.currentTimeMillis());
                    Thread.sleep(2000);
                    numberWrapper.value++;
                    comCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{
                    lock.unlock();
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (numberWrapper.value<1) {
                        comCondition.await();
                    }
                    System.out.println("i am threadB! "+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{
                    lock.unlock();
                }
            }
        };

        threadB.start();
        threadA.start();
    }

    public final void test() {

    }

    public void test(String test) {

    }

    public void setVal() {
    }
}
