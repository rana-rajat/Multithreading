package Locks;

import java.util.concurrent.locks.ReentrantLock;

public class SecondLockVsLockInterruptibly {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1 acquired lock and is sleeping...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 interrupted while sleeping");
                }
            } finally {
                lock.unlock();
                System.out.println("Thread 1 released lock");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Thread 2 trying to acquire lock...");
                // change to lock() and see difference
                lock.lockInterruptibly();
                System.out.println("Thread 2 acquired lock!");
            } catch (InterruptedException e) {
                System.out.println("Thread 2 interrupted while waiting for lock!");
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    System.out.println("Thread 2 released lock");
                }
            }
        });

        t1.start();
        Thread.sleep(100); // ensure t1 acquires the lock
        t2.start();

        Thread.sleep(1000);
        t2.interrupt(); // interrupt t2 while waiting
    }
}
