import java.util.Arrays;

public class Main implements Runnable {

    public void run() {

    }

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = new int[3][3];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i]));
        }

        System.out.println(sb.toString());
    }
}
