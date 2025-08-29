package ExecutorFramework;

public class ThirdRunnalbe implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
