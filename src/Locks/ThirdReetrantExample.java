package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThirdReetrantExample {

    // Create a ReentrantLock instance (default: non-fair lock)
    // ReentrantLock allows the same thread to acquire the lock multiple times.
    private final Lock lock = new ReentrantLock();

    /**
     * Outer method acquires the lock, does some work,
     * and then calls innerMethod() which also tries to acquire the same lock.
     * Thanks to "reentrancy", the same thread is allowed to acquire it again.
     */
    public void outerMethod() {
        lock.lock(); // Thread acquires the lock (hold count = 1)
        try {
            System.out.println("Outer Method");

            // Calls innerMethod() which also locks the same ReentrantLock
            innerMethod();
        } finally {
            lock.unlock(); // Release one level of lock (hold count decreases by 1)
        }
    }

    /**
     * Inner method also tries to acquire the same lock.
     * Without reentrancy, this would cause a deadlock.
     * But with ReentrantLock, the same thread can re-acquire the lock.
     */
    public void innerMethod() {
        lock.lock(); // Same thread acquires lock again (hold count = 2)
        try {
            System.out.println("Inner Method");
        } finally {
            lock.unlock(); // Release one level of lock (hold count decreases by 1)
        }
    }

    public static void main(String[] args) {
        ThirdReetrantExample rt = new ThirdReetrantExample();

        // Call outerMethod which internally calls innerMethod
        // Demonstrates the reentrant nature of ReentrantLock
        rt.outerMethod();
    }
}
