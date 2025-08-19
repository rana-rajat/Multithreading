package Synchronization;

public class SynchronizationFirst {

    private int count = 0;

    // synchronized keyword is used to make sure that only one thread can access this method at a time
    //mutual exclusion is achieved by using synchronized keyword and synchronized block
    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
