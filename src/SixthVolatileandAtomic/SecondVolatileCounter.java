package SixthVolatileandAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class SecondVolatileCounter {
    //int counter = 0;
    // so without using synchronized and intrinsic lock we can use atomic and also thread safe
    AtomicInteger counter = new AtomicInteger(0);


    public void increment() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        SecondVolatileCounter obj = new SecondVolatileCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                obj.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                obj.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(obj.getCounter());
    }
}
