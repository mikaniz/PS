import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedWriter bw;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		find(new int[M], new boolean[N + 1], 0);
		bw.flush();
		bw.close();
	}
	
	public static void find(int[] bucket, boolean[] visited, int n) throws IOException {
		if (n == M) {
			for (int i = 0; i < M; i++) {
				if (i != 0) {
					bw.write(" ");
				}
				bw.write(String.valueOf(bucket[i]));
				if (i == M -1) {
					bw.newLine();
				}
			}
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				bucket[n] = i;
				find(bucket, visited, n + 1);
				visited[i] = false;
			}
		}
	}

}
