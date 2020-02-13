package by.epam.javatraining.matrix.util;

import by.epam.javatraining.matrix.exception.UtilException;
import by.epam.javatraining.matrix.validator.Validator;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    private Validator validator = Validator.getInstance();

    private StringParser() {
    }

    private static class StringParserHolder {
        private static final StringParser instance = new StringParser();
    }

    public static StringParser getInstance() {
        return StringParserHolder.instance;
    }

    public String parseListToString(List<Integer> list) {
        return list.toString().replaceAll("\\[|\\]", "").replaceAll(", ","\t");
    }

    public String parseMatrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i]));
        }

        return sb.toString();
    }

    public int parseStringToMatrixSize(String strData) throws UtilException {
        if (!validator.checkDataFromFile(strData)) {
            throw new UtilException();
        }

        String[] dataArray = strData.split(" ");
        int size = 0;
        size = Integer.parseInt(dataArray[0]);

        return size;
    }
}
