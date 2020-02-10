package by.epam.javatraining.matrix.service;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceHelperThread extends Thread {
    private static final Lock lock = new ReentrantLock();
    private static final Semaphore semaphore = new Semaphore(5);
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    private static int idCounter = 0;

    public ServiceHelperThread() {
        super(String.valueOf(idCounter++));
    }

    @Override
    public void run() {
        lock.lock();
        int diagonalPlace = findPlaceToInsertThreadNameToMatrixDiagonal();
        insertThreadNameNumberIntoDiagonal(diagonalPlace);
        insertValueIntoColumnOrRowOfMatrix(diagonalPlace);
        lock.unlock();
        int sum = findSumOfColumnAndRowElements(diagonalPlace);
    }
}
