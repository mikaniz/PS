import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		long[] trees = new long[N];
		long longestTree = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (trees[i] > longestTree) {
				longestTree = trees[i];
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(binarySearch(0, longestTree, M, trees, N)));
		bw.newLine();
		bw.flush();
		bw.close();
	}
	
	public static long binarySearch(long left, long right, long keyCount, long[] trees, int treeCount) {
		while (left <= right) {
			long mid = (left + right) / 2;
			
			long count = 0;
			for (int i = 0; i < treeCount; i++) {
				count += trees[i] - mid > 0 ? trees[i] - mid : 0;
			}
			
			if (count >= keyCount) {
				long searchMore = binarySearch(mid + 1, right, keyCount, trees, treeCount);
				return searchMore > mid ? searchMore : mid;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
