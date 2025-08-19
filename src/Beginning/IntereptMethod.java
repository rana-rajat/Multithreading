package Beginning;

public class IntereptMethod extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread is Running");
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread Interrupted "+e);
        }
    }

    public static void main(String[] args) {
        IntereptMethod t1 = new IntereptMethod();
        t1.start();
        t1.interrupt();
    }
}
