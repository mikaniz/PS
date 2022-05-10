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
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] X = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int len = A.length;
		for (int i = 0; i < M; i++) {
			bw.write(String.valueOf(binarySearch(A, 0, len - 1, X[i])));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	public static int binarySearch(int[] A, int left, int right, int x) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == x) {
				return 1;
			} else if (A[mid] < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return 0;
	}

}
