package by.epam.javatraining.matrix.util;

import java.util.List;

public class StringParser {

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
            sb.append(matrix[i].toString());
        }

        return sb.toString();
    }
}
