import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		
		int len = nums.length();
		long result = nums.charAt(0) - '0';
		for (int i = 1; i < len; i++) {
			int num = nums.charAt(i) - '0';
			if (result <= 1 || num == 1) {
				result += num;
			} else {
				result *= num;
			}
		}
		
		System.out.println(result);
	}

}
