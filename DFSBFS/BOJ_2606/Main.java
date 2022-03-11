import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N + 1];
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		System.out.println(dfs(1));
	}
	
	public static int dfs(int n) {
		int count = 0;
		visited[n] = true;
		
		ArrayList<Integer> nodes = graph.get(n);
		for (int node : nodes) {
			if (!visited[node]) {
				count++;
				count += dfs(node);
			}
		}
		
		return count;
	}

}
