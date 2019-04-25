import java.util.*;

public class Experiment4 {
    public static void main(String[] args) {
    }
}

class TestMatrix {
    public static Scanner reader = new Scanner(System.in);
    //输入行数、列数
    public static int arows = reader.nextInt();
    public static int acols = reader.nextInt();
    //声明数组
    public static int[][] a = new int[arows][acols];
    public static int[][] b = new int[acols][arows];

    public static void input() {
        //输入数组元素
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
    //获取行数、列数
    public static int arows = TestMatrix.reader.nextInt();
    public static int acols = TestMatrix.reader.nextInt();
    //声明结果数组
    public static int[][] result = new int[arows][acols];

    public static void add(int[][] a, int[][] b) {
        //矩阵加法
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                result[r][c] = calElm();
            }
        }
    }
}