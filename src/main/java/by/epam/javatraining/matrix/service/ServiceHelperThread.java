package by.epam.javatraining.matrix.service;

import by.epam.javatraining.matrix.util.TxtSumResultAndMatrixWriter;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceHelperThread extends Thread {
    private static final Logger LOGGER = Logger.getLogger(ServiceHelperThread.class);
    private static final int THREAD_ON_GROUP = 5;
    private static Lock lock = new ReentrantLock();
    private static Semaphore semaphore;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_ON_GROUP, new TxtSumResultAndMatrixWriter());
    private static MatrixService service = MatrixService.getInstance();
    private static List<Integer> listOfSumResult = new ArrayList<>();
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
            LOGGER.error("Thread was interrupted in the semaphore acquire method!", e);
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
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            LOGGER.error("Thread was interrupted in the cyclingbarier await method!", e);
        } catch (BrokenBarrierException e) {
            LOGGER.error("Barrier in broken state!", e);
        }

        semaphore.release();
    }
}
