package Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Locks in multithreading
public class BankAccount {
    private int balacne = 100;

    private final Lock lock = new ReentrantLock();

    public void wihtdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balacne >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with the withdrawal");
                        Thread.sleep(3000);
                        balacne -= amount;
                        System.out.println(Thread.currentThread().getName() + " Completed with the Withdrawal " + balacne);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName());
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Could not acquire the lock, will try again later ");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.out.println("Got the Exception " + e);
        }
    }
}
