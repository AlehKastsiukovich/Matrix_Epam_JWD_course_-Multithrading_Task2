package by.epam.javatraining.matrix.service;

import by.epam.javatraining.matrix.entity.Matrix;
import java.util.Random;

public class MatrixService extends Thread {
    private static Matrix matrix = Matrix.getInstance();
    private static int idCounter = 1;

    public MatrixService() {
        super(String.valueOf(idCounter++));
    }

    @Override
    public void run() {

    }

    public void insertThreadNameNumberIntoDiagonal() {
        Random random = new Random();
        int value = random.nextInt(matrix.getN());
    }
}
