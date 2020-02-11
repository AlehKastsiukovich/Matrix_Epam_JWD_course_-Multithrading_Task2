package by.epam.javatraining.matrix.util;

import by.epam.javatraining.matrix.entity.MatrixHolder;
import by.epam.javatraining.matrix.service.ServiceHelperThread;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TxtSumResultAndMatrixWriter implements Runnable {
    private String filePath = "file.txt";

    @Override
    public void run() {
        MatrixHolder matrixHolder = MatrixHolder.getInstance();
        List<Integer> resultList = ServiceHelperThread.getListOfSumResult();
        writeMatrixAndSumResultToFile(resultList, matrixHolder.getMatrix());
    }

    private static class TxtSumResultAndMatrixWriterHolder {
        private static final TxtSumResultAndMatrixWriter writer = new TxtSumResultAndMatrixWriter();
    }

    public static TxtSumResultAndMatrixWriter getInstance() {
        return TxtSumResultAndMatrixWriterHolder.writer;
    }

    public void writeMatrixAndSumResultToFile(List<Integer> listOfSums, int[][] matrix) {
        StringParser parser = StringParser.getInstance();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(parser.parseListToString(listOfSums));
            listOfSums.removeAll(listOfSums);
            bufferedWriter.append("\n");
            bufferedWriter.write(parser.parseMatrixToString(matrix));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

