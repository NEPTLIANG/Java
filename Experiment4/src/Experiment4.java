import java.util.*;
/*Test case 1:
3 3
1 2 3
4 5 6
7 8 9
2 1 0
2 1 0
2 1 0
Text case 2:
3 3
2 0 2
1 0 1
0 0 1
2 1 0
0 1 0
2 1 0
*/

public class Experiment4 {
    public static void main(String[] args) {
        TestMatrix.input();  //输入数组
        TestMatrix.test();  //测试
    }
}

class TestMatrix {
    public static Scanner reader = new Scanner(System.in);
    // 输入行数、列数
    public static int arows = reader.nextInt();
    public static int acols = reader.nextInt();
    // 声明数组
    public static int[][] a = new int[arows][acols];
    public static int[][] b = new int[acols][arows];

    public static void input() {
        // 输入数组元素，被main函数调用
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

    public static void test() {  //被main()函数调用
        IntergerMatrix.arrayAdd(a, b);  //调用矩阵加法
        output('+');
        System.out.println();
        IntergerMatrix.arrayMulti(a, b);  //调用矩阵乘法
        output('*');
    }

    public static void output(char oper) {
        // 輸出結果數組
        int[][] result = IntergerMatrix.result;
        for (int i = 0; i < a.length / 2; i++) {
            // 打印上面的行
            printArrayLine(a, i);
            System.out.print("  ");
            printArrayLine(b, i);
            System.out.print("  ");
            printArrayLine(result, i);
            System.out.println();
        }
        // 打印帶加號、等號那行
        printArrayLine(a, a.length / 2);
        System.out.print(oper + " ");
        printArrayLine(b, a.length / 2);
        System.out.print("= ");
        printArrayLine(result, a.length / 2);
        System.out.println();
        for (int i = a.length / 2 + 1; i < a.length; i++) {
            // 打印下面的行
            printArrayLine(a, i);
            System.out.print("  ");
            printArrayLine(b, i);
            System.out.print("  ");
            printArrayLine(result, i);
            System.out.println();
        }
    }

    public static void printArrayLine(int[][] array, int rows) {
        for (int i = 0; i < array[0].length; i++) {
            System.out.print(array[rows][i] + " ");
        }
    }
}

class IntergerMatrix {
    // 获取行数、列数
    public static int arows = TestMatrix.arows;
    public static int acols = TestMatrix.acols;
    // 声明结果数组
    public static int[][] result = new int[arows][acols];

    public static void arrayAdd(int[][] a, int[][] b) {
        // 矩阵加法，被test方法调用
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                result[r][c] = a[r][c] + b[r][c];
            }
        }
    }

    public static void arrayMulti(int[][] a, int[][] b) {
        // 矩阵乘法，被test方法调用

        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                result[r][c] = 0;
                result[r][c] = elmMulti(r, c);
            }
        }
    }

    /**
     * 計算矩陣乘法中的result[r][s]
     *
     * @param r 元素所在行數
     * @param c 元素所在列數
     * @return res result[r][s]
     */
    public static int elmMulti(int r, int c) {
        // 計算矩陣乘法中的result[r][s]，被arrayMulti方法调用
        int res = 0;
        for (int i = 0; i < acols; i++) {
            res += TestMatrix.a[r][i] * TestMatrix.b[i][c];
        }
        return res;
    }
}