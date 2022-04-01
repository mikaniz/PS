import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] triangle = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					triangle[i][j] += triangle[i - 1][j];
				} else if (j == i) {
					triangle[i][j] += triangle[i - 1][j - 1];
				} else {
					triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
				}
			}
		}
		
		Arrays.sort(triangle[N - 1]);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(triangle[N - 1][N - 1]) + "\n");
		bw.flush();
		bw.close();
	}

}
