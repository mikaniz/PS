import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	
	static int[] wine;
	static Integer[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		wine = new int[N + 1];
		memo = new Integer[N + 1];
		for (int i = 1; i < N + 1; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		memo[0] = 0;
		findMax(N);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(memo[N]) + "\n");
		bw.flush();
		bw.close();
	}
	
	public static int findMax(int n) {
		if (memo[n] == null) {
			if (n == 1) {
				memo[n] = wine[n];
			} else if (n == 2) {
				memo[n] = wine[n] + wine[n - 1];
			} else {
				memo[n] = Math.max(Math.max(findMax(n - 2), findMax(n - 3) + wine[n - 1]) + wine[n], findMax(n - 1));
			}
		}
		return memo[n];
	}

}
