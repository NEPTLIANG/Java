import java.io.*;
/*
    Excel是最常用的办公软件。每个单元格都有唯一的地址表示。 比如：第12行第4列表示为：“D12”，第5行第255列表示为“IU5”。
    事实上，Excel提供了两种地址表示方法，还有一种表示法叫做RC格式地址。
    第12行第4列表示为：“R12C4”，第5行第255列表示为“R5C255”。
    你的任务是：编写程序，实现从RC地址格式到常规地址格式的转换。
    【输入、输出格式要求】
    用户先输入一个整数n（n<100），表示接下来有n行输入数据。接着输入的n行数据是RC格式的Excel单元格地址表示法。程序则输出n行数据，每行是转换后的常规地址表示法。
    例如：用户输入：
    2
    R34C6
    R56C67
    则程序应该输出：
    F34
    BO56
*/

public class Experiment2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(inp);
        int n = Integer.parseInt(buf.readLine());
        while ((n--) != 0) {
            String str = buf.readLine();
            int rLocation = str.indexOf("R");
            //public int indexOf(String str):返回str所在字符串中第一次出现的位置
            int cLocation = str.indexOf("C");
            int rows = Integer.parseInt(str.substring(rLocation + 1, cLocation));
            //public String substring(int beginIndex, int endIndex):
            //返回从beginIndex开始到endIndex-1的字串
            int cols = Integer.parseInt(str.substring(cLocation + 1, str.length()));
            String result = "";
            while (cols != 0) {
                char letter = (char) (cols % 26 + 64);  //ASCII码值和字符之间的转化可以强制类型转换
                cols /= 26;
                result = letter + result;
            }
            result += rows;
            System.out.println(result);
        }
    }
}