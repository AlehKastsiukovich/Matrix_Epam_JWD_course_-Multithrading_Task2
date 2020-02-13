package by.epam.javatraining.matrix.entity;

public class MatrixHolder {
    private int n;
    private int[][] matrix;

    private MatrixHolder() {
    }

    private static class MatrixHolderCreator {
        private static final MatrixHolder INSTANCE = new MatrixHolder();
    }

    public static MatrixHolder getInstance() {
        return MatrixHolderCreator.INSTANCE;
    }

    public int getN() {
        return n;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
