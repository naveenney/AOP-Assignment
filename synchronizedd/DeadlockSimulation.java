package synchronizedd;

class ResourceA {
    public synchronized void methodA(ResourceB resourceB) {
        System.out.println(Thread.currentThread().getName() + ": Locked ResourceA");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": Attempting to lock ResourceB");
        synchronized (resourceB) {
            System.out.println(Thread.currentThread().getName() + ": Locked ResourceB");
        }
    }
}

class ResourceB {
    public synchronized void methodB(ResourceA resourceA) {
        System.out.println(Thread.currentThread().getName() + ": Locked ResourceB");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": Attempting to lock ResourceA");
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + ": Locked ResourceA");
        }
    }
}

public class DeadlockSimulation {
    public static void main(String[] args) {
        final ResourceA resourceA = new ResourceA();
        final ResourceB resourceB = new ResourceB();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                resourceA.methodA(resourceB);
            }
        }, "Thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                resourceB.methodB(resourceA);
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
