import java.util.*;

public class Experiment4 {
    public static void main(String[] args) {
    }
}

class TestMatrix {
    public static Scanner reader = new Scanner(System.in);
    public static int arows = reader.nextInt();
    public static int acols = reader.nextInt();
    public static int[][] a = new int[arows][acols];
    public static int[][] b = new int[acols][arows];

    public static void input() {

        for (int r = 0; r < arows; r++) {
            for (int c = 0; c < acols; c++) {
                a[r][c] = reader.nextInt();
            }
        }
        for (int r = 0; r < acols; r++) {
            for (int c = 0; c < arows; c++) {
                b[r][c] = reader.nextInt();
            }
        }
    }

    public static void test() {

    }
}

class IntergerMatrix {
    public static int arows = TestMatrix.reader.nextInt();
    public static int acols = TestMatrix.reader.nextInt();
    public static int[][] result = new int[arows][acols];

    public static void add(int[][] a, int[][] b) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                result[r][c] = calElm();
            }
        }
    }
}