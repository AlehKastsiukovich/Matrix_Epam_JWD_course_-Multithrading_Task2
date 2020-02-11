package by.epam.javatraining.matrix.service;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceHelperThread extends Thread {
    private static Lock lock = new ReentrantLock();
    private static Semaphore semaphore;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    private static MatrixService service = MatrixService.getInstance();
    private static int idCounter = 0;

    static {
        semaphore = new Semaphore(service.getMatrix().getN());
    }

    public ServiceHelperThread() {
        super(String.valueOf(idCounter++));
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.lock();
        int diagonalPlace = service.findPlaceToInsertThreadNameToMatrixDiagonal();
        service.insertThreadNameNumberIntoDiagonal(diagonalPlace);
        service.insertValueIntoColumnOrRowOfMatrix(diagonalPlace);
        int sum = service.findSumOfColumnAndRowElements(diagonalPlace);
        lock.unlock();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        //write file

        semaphore.release();
    }
}
