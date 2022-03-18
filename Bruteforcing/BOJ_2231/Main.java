import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		for (int i = 1; i < N; i++) {
			if (splitSum(i) == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
	
	public static int splitSum(int n) {
		int result = n;
		
		while(n > 0) {
			result += n % 10;
			n /= 10;
		}
		
		return result;
	}

}
