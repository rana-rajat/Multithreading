package ThirdCommunication;

class SharedResource {

    private int data;

    private boolean hasData;

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();  // if data already present, producer waits
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced " + value);
        notify();  // wake up waiting consumer
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();  // if no data, consumer waits
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;  // consumed data, so flag reset
        System.out.println("Consumed " + data);
        notify();  // wake up producer
        return data;
    }
}

class Producer implements Runnable {
    private SharedResource sharedResource;

    public Producer(SharedResource resource) {
        this.sharedResource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            sharedResource.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            int value = sharedResource.consume();
        }
    }
}

public class FirstCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
