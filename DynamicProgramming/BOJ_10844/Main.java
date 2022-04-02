import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] memo = new int[N + 1][10];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 1 && j != 0) {
					memo[i][j] = 1;
				} else if (j == 0) {
					memo[i][j] = memo[i - 1][j + 1] % 1000000000;
				} else if (j == 9) {
					memo[i][j] = memo[i - 1][j - 1] % 1000000000;
				} else {
					memo[i][j] = (memo[i - 1][j - 1] + memo[i - 1][j + 1]) % 1000000000;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + memo[N][i]) % 1000000000;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(sum) + "\n");
		bw.flush();
		bw.close();
	}

}
