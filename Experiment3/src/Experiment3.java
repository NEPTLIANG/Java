import java.io.*;
/*实验3：1、编写一个方法验证一个IP地址的格式是否正确，正确返回true，不正确返回false，该方法可定义如下
public boolean isRightIP(String ip)
其中，参数是要验证的IP字符串。（注：IP地址由4部分构成，即a.b.c.d，每个部分是0~255的整数）
2、从键盘读入以字符，在main方法中调用isRightIP(String ip)以测试输入的字符串是否为合法的IP，给出结果。*/
//Test case: 192.168.1.1, 255.0.255.0, 192.0.256.0, 192.512.1.1, 255.0.-1.0

public class Experiment3 {

    public static void main(String[] args) throws IOException {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(inp);
        String ip = buf.readLine();
        if (isRightIP(ip)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean isRightIP(String ip) {
        for (int i = 0; i < 3; i++) {
            int indexOfPoint = ip.indexOf(".");
            int num = Integer.parseInt(ip.substring(0, indexOfPoint));
            if (num > 255 || num < 0) {
                return false;
            }
            ip = ip.substring(indexOfPoint + 1, ip.length());
        }
        return true;
    }

}
