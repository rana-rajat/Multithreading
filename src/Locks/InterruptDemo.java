package Locks;

import java.util.concurrent.TransferQueue;

public class InterruptDemo {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000); // 1 sec work
                    System.out.println("Progress: " + (i + 1) + " seconds");

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Task interrupted, cleaning up...");
                        return;
                    }
                }
                System.out.println("Task completed successfully!");
            } catch (InterruptedException e) {
                System.out.println("Interrupted while sleeping, stopping task!");
                Thread.currentThread().interrupt(); // restore status
            }
        });

        worker.start();

        // main thread interrupts the worker after 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread sending interrupt signal...");
    //    worker.interrupt(); // <--- THIS is the thread that interrupts
    }
}
