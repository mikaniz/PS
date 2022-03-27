import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[] nums;
	static int[] operator;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		operator = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		backtracking(nums[0], 1);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(max) + "\n");
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
	}
	
	public static void backtracking(int result, int n) {
		if (n == N) {
			if (result > max) {
				max = result;
			}
			if (result < min) {
				min = result;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				switch (i) {
				case 0:
					backtracking(result + nums[n], n + 1);
					break;
				case 1:
					backtracking(result - nums[n], n + 1);
					break;
				case 2:
					backtracking(result * nums[n], n + 1);
					break;
				case 3:
					backtracking(result / nums[n], n + 1);
					break;
				}
				operator[i]++;
			}
		}
	}

}
