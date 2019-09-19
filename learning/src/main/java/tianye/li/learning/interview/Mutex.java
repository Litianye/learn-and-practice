package tianye.li.learning.interview;
/**
 * Created by litianye on 2019-08-22
 */


import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import com.google.common.hash.Hasher;

/**
 * @program: learn_and_practice
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-08-22
 **/

public class Mutex implements Lock, Serializable {
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;
            if (compareAndSetState(0, arg)) {
                setExclusiveOwnerThread(Thread.currentThread());
                System.out.println(Thread.currentThread().getName()+" :自定义加锁成功");
                return true;
            }
            System.out.println(Thread.currentThread().getName()+" :自定义加锁失败");
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            System.out.println(Thread.currentThread().getName()+" :自定义解锁成功");
            return true;
        }



        Condition newCondition() {
            return new ConditionObject();
        }

        private void readObject(java.io.ObjectInputStream s)
                throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        System.out.println(Thread.currentThread().getName()+" :尝试加锁");
        sync.acquire(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }
}
