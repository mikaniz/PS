import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static int[][] graph;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = data.charAt(j) - '0';
			}
		}
		
		int result = 0;
		ArrayList<Integer> count = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int n = dfs(i, j);
				if (n > 0) {
					result++;
					count.add(n);
				}
			}
		}
		
		System.out.println(result);
		Collections.sort(count);
		for (int i = 0; i < result; i++) {
			System.out.println(count.get(i));
		}
	}
	
	public static int dfs(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) {
			return 0;
		}
		if (graph[x][y] == 1) {
			int count = 1;
			graph[x][y] = 0;
			
			count += dfs(x - 1, y);
			count += dfs(x + 1, y);
			count += dfs(x, y - 1);
			count += dfs(x, y + 1);
			
			return count;
		}
		return 0;
	}

}
