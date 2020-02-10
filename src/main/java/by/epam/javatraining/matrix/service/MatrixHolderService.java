package by.epam.javatraining.matrix.service;

import by.epam.javatraining.matrix.entity.MatrixHolder;
import java.util.Random;

public class MatrixHolderService extends Thread {
    private static MatrixHolder matrix = MatrixHolder.getInstance();
    private static Random random = new Random();
    private static int idCounter = 1;

    public MatrixHolderService() {

    }



    public void insertThreadNameNumberIntoDiagonal(int diagonalPlace) {
        matrix.getMatrix()[diagonalPlace][diagonalPlace] = Integer.parseInt(Thread.currentThread().getName());
    }

    private int findPlaceToInsertThreadNameToMatrixDiagonal() {
        return random.nextInt(matrix.getN());
    }

    public void insertValueIntoColumnOrRowOfMatrix(int diagonalPlace) {
        int randomValue = random.nextInt(3) + 1;
        int insertPlace = 0;

        switch (randomValue) {
            case 1:
                insertPlace = goLeft(diagonalPlace);
                matrix.getMatrix()[diagonalPlace][insertPlace] = matrix.getMatrix()[diagonalPlace][diagonalPlace];
                break;
            case 2:
                insertPlace = goRight(diagonalPlace);
                matrix.getMatrix()[diagonalPlace][insertPlace] = matrix.getMatrix()[diagonalPlace][diagonalPlace];
                break;
            case 3:
                insertPlace = goUp(diagonalPlace);
                matrix.getMatrix()[insertPlace][diagonalPlace] = matrix.getMatrix()[diagonalPlace][diagonalPlace];
                break;
            case 4:
                insertPlace = goDown(diagonalPlace);
                matrix.getMatrix()[insertPlace][diagonalPlace] = matrix.getMatrix()[diagonalPlace][diagonalPlace];
                break;
        }
    }

    public int findSumOfColumnAndRowElements(int diagonalPlace) {
        int sum = 0;
        for (int i = 0; i < matrix.getMatrix()[diagonalPlace].length; i++) {
            sum += matrix.getMatrix()[diagonalPlace][i];
        }

        for (int i = 0; i < matrix.getMatrix().length; i++) {
            sum += matrix.getMatrix()[i][diagonalPlace];
        }

        return sum;
    }

    private int goLeft(int diagonalPlace) {
        if (diagonalPlace == 0) {
            return goRight(diagonalPlace);
        }

        return random.nextInt(diagonalPlace);
    }

    private int goRight(int diagonalPlace) {
        if (diagonalPlace == matrix.getMatrix().length - 1) {
            return goLeft(diagonalPlace);
        }

        int minRange = diagonalPlace + 1;
        int maxRange = matrix.getMatrix().length - 1;
        return random.nextInt((maxRange - minRange) + 1) + minRange;
    }

    private int goUp(int diagonalPlace) {
        if (diagonalPlace == 0) {
            return goDown(diagonalPlace);
        }

        return random.nextInt(diagonalPlace);
    }

    private int goDown(int diagonalPlace) {
        if (diagonalPlace == matrix.getMatrix().length) {
            return goUp(diagonalPlace);
        }

        int minRange = diagonalPlace + 1;
        int maxRange = matrix.getMatrix().length - 1;
        return random.nextInt((maxRange - minRange) + 1) + minRange;
    }


}
