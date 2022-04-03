import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] memo = new int[N];
		for (int i = 0; i < N; i++) {
			memo[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (memo[i] > max) {
				max = memo[i];
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(max) + "\n");
		bw.flush();
		bw.close();
	}

}
