import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		memo = new int[N + 1];
		bw.write(String.valueOf(getCount(N)) + "\n");
		bw.flush();
		bw.close();
	}
	
	public static int getCount(int n) {
		if (memo[n] == 0) {
			if (n == 1) {
				memo[n] = 1;
			} else if (n == 2) {
				memo[n] = 2;
			} else {
				memo[n] = (getCount(n - 1) + getCount(n - 2)) % 15746;
			}
		}
		return memo[n];
	}

}
