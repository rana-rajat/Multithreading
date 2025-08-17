package MultiThreading;

public class ThreadClass extends Thread{
    private final SynchronizationSecond counter;

    public ThreadClass(SynchronizationSecond counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){;
            counter.increment();
        }
    }
}
