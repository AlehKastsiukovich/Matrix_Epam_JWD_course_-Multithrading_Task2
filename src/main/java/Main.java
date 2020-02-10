

import java.util.concurrent.*;

public class Main implements Runnable {
    private static Semaphore semaphore = new Semaphore(3);

    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " start task!");

        if (semaphore.hasQueuedThreads()) {
            semaphore.release();
        }
        System.out.println(Thread.currentThread().getName() + " end task!");
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 30; i++) {
            service.submit(new Main());
        }

        service.shutdown();


//        for (int i = 0; i < matrix.getMatrix().length; i++) {
//            System.out.println(Arrays.toString(matrix.getMatrix()[i]));
//        }

    }
}
