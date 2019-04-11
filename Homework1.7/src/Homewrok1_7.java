import java.io.*;

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