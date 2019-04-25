import java.io.*;

public class CalculateNumberOfWords {

    public static void main(String[] args) throws IOException {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(inp);
        String ip = buf.readLine();
        int a = ip.indexOf(" ");
        int sum = 0;
        while (a != -1) {
            if(ip.substring(0, a)!="" && ip.substring(a+1, ip.length())!="") {
                sum++;
            }
            ip = ip.substring(0, a) + ip.substring(a+1, ip.length());
            a = ip.indexOf(" ");
        }
        a = ip.indexOf(",");
        while (a != -1) {
            if(ip.substring(0, a)!="" && ip.substring(a+1, ip.length())!="") {
                sum++;
            }
            ip = ip.substring(0, a) + ip.substring(a+1, ip.length());
            a = ip.indexOf(",");
        }
        a = ip.indexOf(".");
        while (a != -1) {
            if(ip.substring(0, a)!="" && ip.substring(a+1, ip.length())!="") {
                sum++;
            }
            ip = ip.substring(0, a) + ip.substring(a+1, ip.length());
            a = ip.indexOf(".");
        }
        System.out.println(sum + 1);
        //Test case: The quieter.you become, the more,you are.able to hear.
    }
}