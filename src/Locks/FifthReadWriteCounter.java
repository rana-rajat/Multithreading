package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FifthReadWriteCounter {
    private int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FifthReadWriteCounter counter = new FifthReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read : " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " Incremented ");
                }
            }
        };

        Thread writerThread = new Thread(writeTask);
        Thread readThread = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writerThread.start();
        readThread.start();
        readThread2.start();

        writerThread.join();
        readThread.join();
        readThread2.join();

        System.out.println("Final Count " + counter.getCount());
    }

}
