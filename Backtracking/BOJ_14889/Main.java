import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] stat;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		stat = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		matching(new boolean[N], 0, 0);
		
		System.out.println(min);
	}
	
	public static void matching(boolean[] visited, int n, int k) {
		if (n == N / 2) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] && visited[j]) {
						sum1 += stat[i][j];
						sum1 += stat[j][i];
					} else if (!visited[i] && !visited[j]) {
						sum2 += stat[i][j];
						sum2 += stat[j][i];
					}
				}
			}
			
			int diff = Math.abs(sum1 - sum2);
			if (diff < min) {
				min = diff;
			}
			
			if (min == 0) {
				System.out.println(min);
				System.exit(0);
			}
			
			return;
		}
		
		for (int i = k; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				matching(visited, n + 1, i + 1);
				visited[i] = false;
			}
		}
	}

}
