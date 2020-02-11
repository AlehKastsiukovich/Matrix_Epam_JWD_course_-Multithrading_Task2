package by.epam.javatraining.matrix.service;

import by.epam.javatraining.matrix.util.TxtSumResultAndMatrixWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceHelperThread extends Thread {
    private static Lock lock = new ReentrantLock();
    private static Semaphore semaphore;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new TxtSumResultAndMatrixWriter());
    private static MatrixService service = MatrixService.getInstance();
    private static List<Integer> listOfSumResult = new ArrayList<>(5);
    private static int idCounter = 1;

    static {
        semaphore = new Semaphore(service.getMatrix().getN());
    }

    public ServiceHelperThread() {
        super(String.valueOf(idCounter++));
    }

    public static List<Integer> getListOfSumResult() {
        return listOfSumResult;
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
        listOfSumResult.add(sum);
        lock.unlock();

        try {
            cyclicBarrier.await();
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        semaphore.release();
    }
}
