package SixthVolatileandAtomic;

class SharedResource {
    private volatile boolean flag = false;

    public void setFlag() {
        System.out.println("Writer Thread made the flag True");
        flag = true;
    }

    public void printFlagTrue() {
        while (!flag) {
            //do nothing and when it comes here even after one second after its true in writer it
            // becomes false because thread store the value in its cache as false however, in main memory it true now
            // and when its volatile it will not take data from its cache it will take from the main memory
        }
        System.out.println("Flag is True!");
    }
}

public class FirstVolatile {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Exception " + e);
            }
            obj.setFlag();
        });
        Thread readerThread = new Thread(() -> {
            obj.printFlagTrue();
        });

        writerThread.start();
        readerThread.start();
    }
}
