import java.io.*;
/*课本P61作业1第4章第7题：从键盘输入一个整数，判断该数是否是完全数。
完全数是指其所有因数（包括1但不包括其自身）的和等于该数自身的数。
例如，28=1+2+4+7+14就是一个完全数。*/

public class Homewrok1_7 {
	public static void main(String[] args) throws IOException {
		InputStreamReader inp = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(inp);
		String str = buf.readLine();
		int num = Integer.parseInt(str);
		int sum = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		if (sum == num) {
			System.out.println("是");
		} else {
			System.out.println("不是");
		}
	}
}