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
		find(new int[M], 0, 1);
		bw.flush();
		bw.close();
	}
	
	public static void find(int[] bucket, int n, int k) throws IOException {
		if (n == M) {
			for (int i = 0; i < M; i++) {
				if (i != 0) {
					bw.write(" ");
				}
				bw.write(String.valueOf(bucket[i]));
			}
			bw.newLine();
			return;
		}
		
		for (int i = k; i <= N; i++) {
			bucket[n] = i;
			find(bucket, n + 1, i);
		}
	}

}
