package Synchronization;

public class SynchronizationSecond extends Thread{
    private final SynchronizationFirst counter;

    public SynchronizationSecond(SynchronizationFirst counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){;
            counter.increment();
        }
    }
}
