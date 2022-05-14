import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long[] lines = new long[K];
		long longestLine = 0;
		for (int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			if (lines[i] > longestLine) {
				longestLine = lines[i];
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(binarySearch(1, longestLine, N, lines, K)) + "\n");
		bw.flush();
		bw.close();
	}
	
	public static long binarySearch(long left, long right, int keyCount, long[] lines, int lineCount) {
		while (left <= right) {
			long mid = (left + right) / 2;
			
			int count = 0;
			for (int i = 0; i < lineCount; i++) {
				count += lines[i] / mid;
			}
			
			if (count >= keyCount) {
				long searchMore = binarySearch(mid + 1, right, keyCount, lines, lineCount);
				return searchMore > mid ? searchMore : mid;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
