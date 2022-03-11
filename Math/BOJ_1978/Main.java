import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for (int n : input) {
			if (n == 1) {
				continue;
			}
			
			boolean isPrime = true;
			for (int i = 2; i < 1000; i++) {
				if (n != i && n % i == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				count++;
			}
		}
		System.out.println(count);
	}

}
