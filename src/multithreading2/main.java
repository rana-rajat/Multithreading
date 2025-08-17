package multithreading2;

public class main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
              account.wihtdraw(50);
            }
        };
        Thread t1 = new Thread("MyThread1");
        Thread t2 = new Thread("MyThread2");
    }

}
