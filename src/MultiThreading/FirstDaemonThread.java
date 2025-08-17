package MultiThreading;

public class FirstDaemonThread extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println("First Thread");
        }
    }

    public static void main(String[] args) {
        FirstDaemonThread fst = new FirstDaemonThread();
        fst.setDaemon(true);
        fst.start(); //a user thread

        System.out.println("End of main thread");

    }
    //Daemon thread is a low priority thread that runs in the background and provides services to user threads.

}
