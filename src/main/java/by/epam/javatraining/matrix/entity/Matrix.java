package by.epam.javatraining.matrix.entity;

public class Matrix {
    private int n;
    private int[][] matrix;

    private Matrix() {
        //init matrix
    }

    private static class MatrixHolder {
        private static final Matrix INSTANCE = new Matrix();
    }

    public static Matrix getInstance() {
        return MatrixHolder.INSTANCE;
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
