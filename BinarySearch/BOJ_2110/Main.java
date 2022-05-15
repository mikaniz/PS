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
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] routers = new int[N];
		for (int i = 0; i < N; i++) {
			routers[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(routers);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(binarySearch(routers, N, 1, routers[N - 1] - routers[0], C)));
		bw.newLine();
		bw.flush();
		bw.close();
	}
	
	public static int binarySearch(int[] routers, int routersLen, int left, int right, int C) {
		while (left <= right) {
			int mid = (left + right) / 2;
			
			int count = 1;
			int pre = 0;
			for (int i = 1; i < routersLen; i++) {
				if (routers[i] - routers[pre] >= mid) {
					count++;
					pre = i;
				}
			}
			
			if (count >= C) {
				int searchMore = binarySearch(routers, routersLen, mid + 1, right, C);
				return searchMore > mid ? searchMore : mid;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
