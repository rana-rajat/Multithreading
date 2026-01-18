package Beginning;

public class PriorityThread extends Thread{
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=0; i<=5;i++){
            System.out.println(Thread.currentThread().getName()+" Priority: "+Thread.currentThread().getPriority()+" Count: "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
     PriorityThread thread1 = new PriorityThread("Low Priority");
     PriorityThread thread2 = new PriorityThread("Medium Priority");
     PriorityThread thread3 = new PriorityThread("High Priority");
     thread2.setPriority(Thread.NORM_PRIORITY);
     thread1.setPriority(Thread.MIN_PRIORITY);
     thread3.setPriority(Thread.MAX_PRIORITY);
     thread1.start();
     thread2.start();
     thread3.start();
     thread2.join();
     thread3.join();
     thread1.join();
    }
}
