package by.epam.javatraining.matrix.service;

import by.epam.javatraining.matrix.entity.MatrixHolder;
import by.epam.javatraining.matrix.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;

public class MatrixServiceTest {

    @Test
    public void testFindSumOfColumnAndRowElements3On3Matrix() {
        MatrixService matrixService = MatrixService.getInstance();
        MatrixHolder matrixHolder = MatrixHolder.getInstance();

        int[][] matrix = {  {2, 4, 5},
                            {5, 6, 7},
                            {1, 2, 3}};
        matrixHolder.setMatrix(matrix);

        int diagonalPlace = 1;
        int excepted = 30;

        int actual = matrixService.findSumOfColumnAndRowElements(diagonalPlace);

        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void  testInitMatrix() throws ServiceException {
        MatrixService matrixService = MatrixService.getInstance();
        MatrixHolder matrixHolder = MatrixHolder.getInstance();

        int[][] excepted = new int[5][5];

        matrixService.initMatrix();

        int[][] actual = matrixHolder.getMatrix();

        Assert.assertArrayEquals(excepted, actual);
    }
}
