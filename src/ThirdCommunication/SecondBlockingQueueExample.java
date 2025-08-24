package ThirdCommunication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producerr implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producerr(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i++) {
                queue.put(i);  // waits if queue is full
                System.out.println("Produced " + i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumerr implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumerr(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i++) {
                int value = queue.take();  // waits if queue is empty
                System.out.println("Consumed " + value);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class SecondBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        // capacity = 1 → acts like your single-slot buffer

        Thread producerThread = new Thread(new Producerr(queue));
        Thread consumerThread = new Thread(new Consumerr(queue));

        producerThread.start();
        consumerThread.start();
    }
}
