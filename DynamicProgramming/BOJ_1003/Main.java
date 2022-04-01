import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	static int[][] count = new int[41][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			getCount(nums[i]);
			bw.write(String.valueOf(count[nums[i]][0]) + " " + String.valueOf(count[nums[i]][1]) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void getCount(int n) {
		if (count[n][0] == 0 && count[n][1] == 0) {
			if (n == 0) {
				count[n][0] = 1;
			} else if (n == 1) {
				count[n][1] = 1;
			} else {
				getCount(n - 1);
				getCount(n - 2);
				count[n][0] = count[n - 1][0] + count[n - 2][0];
				count[n][1] = count[n - 1][1] + count[n - 2][1];
			}
		}
	}

}
