import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N + 1];
		int[] money = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			if (i + time[i] - 1 <= N) {
				dp[i + time[i] - 1] = Math.max(dp[i + time[i] - 1], dp[i - 1] + money[i]);
			}
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(dp[N]) + "\n");
		bw.flush();
		bw.close();
	}

}
