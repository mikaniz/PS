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
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		int count = 0;
		for (int i = 1; i < N + 1; i++) {
			if (dfs(i)) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static boolean dfs(int n) {
		if (visited[n]) {
			return false;
		} else {
			visited[n] = true;
			
			ArrayList<Integer> nodes = graph.get(n);
			for (int node : nodes) {
				dfs(node);
			}
			return true;
		}
	}

}
