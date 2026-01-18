package Beginning;

public class YieldMethod extends Thread{
    public  YieldMethod (String name) {
        super(name);
    }
    @Override
    public void run() {
        for(int i = 0; i <= 5 ; i++){
            System.out.println(Thread.currentThread().getName()+ " Count: "+i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        YieldMethod t1 = new YieldMethod("First Thread");
        YieldMethod t2 = new YieldMethod("Second Thread");
        t1.start();
       // t1.setDaemon(true); // for daemon
        t2.start();
    }
}
