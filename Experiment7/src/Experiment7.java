import java.io.*;
import java.util.*;

public class Experiment7 {
    public static void main(String[] args) throws IOException {
        boolean isAppend = false;
        FileWriter fw = new FileWriter("file2.txt", isAppend); // 若有第二个参数且为true，则会将数据追加在原先文件的后面；若为false或没有该参数，原先的文件会被覆盖
        BufferedWriter bw = new BufferedWriter(fw); // 必须先创建FileWriter类对象，再以该对象为参数来创建BufferedWriter对象；用来将数据写入到缓冲区里
        String[] num = new String[15];
        for (int i = 0; i < num.length; i++) {
            Random r = new Random(); // 用系统时间作为种子创建Random对象；是java.util包中的类
            num[i] = (r.nextInt(9979) + 20) + ""; // 使用Random对象的nextInt方法返回一個大小在0~9979之間的整形隨機數
            bw.write(num[i]); // 利用BufferedWriter对象的write方法将字符串写入缓冲区中
            bw.newLine(); // 利用BufferedWriter对象的newLine方法将换行写入缓冲区中
        }
        bw.flush(); // 利用BufferedWriter对象的flush方法将缓冲区中的数据写到文件中
        // bw.close(); //利用BufferedWriter对象的close方法关闭流

        FileReader fr = new FileReader("file2.txt"); // 继承自InputStreamReader类；根据文件名称创建一个可读取的输入流对象，用来讀取文件
        BufferedReader br = new BufferedReader(fr); // 必须先创建FileReader类对象，再以该对象为参数来创建BufferedReader类的对象；用来读取缓冲区里的数据

        int[] num2 = new int[15];
        for (int i = 0; i < num2.length; i++) {
            num2[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < num2.length; i++) {
            for (int j = i; j < num2.length; j++) {
                if (num2[i] > num2[j]) {
                    int tmp = num2[i];
                    num2[i] = num2[j];
                    num2[j] = tmp;
                }
            }
        }
        for (int i : num2) {
            System.out.println(i);
        }


        /*String[] num2 = new String[15];
        for (int i = 0; i < num2.length; i++) {
            num2[i] = br.readLine();
        }*/

//        stringQuickSort(num2, 0, num2.length-1);

        /*for (int i = 0; i < num2.length; i++) {
            for (int j = i; j < num2.length; j++) {
                if (num2[i].length() > num2[j].length()) {
                    String tmp = num2[i];
                    num2[i] = num2[j];
                    num2[j] = tmp;
                } else {
                    if (num2[i].compareTo(num2[j]) > 0) {
                        String tmp = num2[i];
                        num2[i] = num2[j];
                        num2[j] = tmp;
                    }
                }
            }
        }*/

        /*for (String i : num2) {
            System.out.println(i);
        }*/

    }

    /*public static void stringQuickSort(String[] s, int low, int high) {
//        int low = 0, high = s.length;
        int l = low, h = high;
        while (l < h) {
            while (l < h && s[l].compareTo(s[h]) < 0) {
                h--;
            }
            String tmp = s[h];
            s[h] = s[l];
            s[l] = tmp;

            while (l < h && s[l].compareTo(s[h]) < 0) {
                l++;
            }
            tmp = s[h];
            s[h] = s[l];
            s[l] = tmp;
        }
        stringQuickSort(s, low, l - 1);
        stringQuickSort(s, l + 1, high);
    }*/
}