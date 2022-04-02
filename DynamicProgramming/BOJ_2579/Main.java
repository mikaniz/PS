import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stair = new int[N + 1];
		int[] memo = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		memo[1] = stair[1];
		for (int i = 2; i < N + 1; i++) {
			if (i == 2) {
				memo[i] = stair[i - 1] + stair[i];
			} else {
				memo[i] = Math.max(memo[i - 2], memo[i - 3] + stair[i - 1]) + stair[i];
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(memo[N]) + "\n");
		bw.flush();
		bw.close();
	}

}
