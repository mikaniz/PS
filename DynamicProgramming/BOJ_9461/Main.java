import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		long[] memo = new long[101];
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(getP(memo, N)) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static long getP(long[] memo, int n) {
		if (memo[n] == 0) {
			if (n <= 3) {
				memo[n] = 1;
			} else if (n <= 5) {
				memo[n] = 2;
			} else {
				memo[n] = getP(memo, n - 1) + getP(memo, n - 5);
			}
		}
		return memo[n];
	}

}
