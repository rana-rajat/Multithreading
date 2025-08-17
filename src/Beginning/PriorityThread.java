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

    public static void main(String[] args) {
     PriorityThread thread1 = new PriorityThread("Thread 1");
     thread1.start();
    }
}
