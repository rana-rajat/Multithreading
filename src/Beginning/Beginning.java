package Beginning;

public class Beginning extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getState()+" "+Thread.currentThread().getName());
        System.out.println("Thread is running");
    }

    public static void main(String[] args) throws InterruptedException {
        Beginning thread = new Beginning();
        System.out.println(thread.getState());
        System.out.println(Thread.currentThread().getName());
        thread.start();
        Thread.sleep(2000);
        thread.join();// Wait for the thread to finish
        System.out.println(thread.getState());
        System.out.println(Thread.currentThread().getState());

    }
}
