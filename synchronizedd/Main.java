package synchronizedd;


class Buffer {
    private int data;
    private boolean isEmpty = true;

    public synchronized void put(int value) throws InterruptedException {
        while (!isEmpty) {
            wait();
        }
        data = value;
        isEmpty = false;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized int get() throws InterruptedException {
        while (isEmpty) {
            wait();
        }
        isEmpty = true;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.put(i);
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.get();
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        
        Thread producer1 = new Thread(new Producer(buffer));
        Thread producer2 = new Thread(new Producer(buffer));
        Thread consumer1 = new Thread(new Consumer(buffer));
        Thread consumer2 = new Thread(new Consumer(buffer));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
