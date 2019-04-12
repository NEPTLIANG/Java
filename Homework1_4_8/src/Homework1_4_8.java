import java.io.*;
//璇炬湰P61涔犻4绗�8棰橈細璁＄畻骞惰緭鍑轰竴涓暣鏁板悇浣嶆暟瀛椾箣鍜屻�傚锛�5423鐨勫悇浣嶆暟瀛椾箣鍜屼负5+4+2+3

public class Homework1_4_8 {
	public static void main(String[] args) throws IOException {
		InputStreamReader inp = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(inp);
		int num = Integer.parseInt(buf.readLine());
		int sum=0, counter=0, temp, i;
		int[] array = new int[20];
		while (num >= 1) {
			temp = num % 10;
			sum += temp;
			array[counter] = temp;
			num /= 10;
			counter++;
		}
		while ((counter--) >= 2) {
			System.out.print(array[counter] + "+");
		}
		System.out.println(array[counter] + "=" + sum);
	}
}