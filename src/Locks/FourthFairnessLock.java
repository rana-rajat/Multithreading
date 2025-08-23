package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FourthFairnessLock {
    private final Lock lock = new ReentrantLock(true);

    public void accessResource() {
      lock.lock();
        try {
            System.out.println("Acquired the lock " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Unlocking the " + Thread.currentThread().getName());
            lock.unlock();

        }

    }

    public static void main(String[] args) {
        FourthFairnessLock test = new FourthFairnessLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                test.accessResource();
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
