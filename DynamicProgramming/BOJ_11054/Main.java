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
		
		int[] memo_f = new int[N];
		for (int i = 0; i < N; i++) {
			memo_f[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					memo_f[i] = Math.max(memo_f[i], memo_f[j] + 1);
				}
			}
		}
		
		int[] memo_b = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			memo_b[i] = 1;
			for (int j = i + 1; j < N; j++) {
				if (nums[i] > nums[j]) {
					memo_b[i] = Math.max(memo_b[i], memo_b[j] + 1);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (memo_f[i] + memo_b[i] - 1 > max) {
				max = memo_f[i] + memo_b[i] - 1;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(max) + "\n");
		bw.flush();
		bw.close();
	}

}
