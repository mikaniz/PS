import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	
	static int N;
	static int[] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N];
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(find(0)));
		bw.flush();
		bw.close();
	}
	
	public static int find(int k) {
		for (int i = 0; i < k - 1; i++) {
			if (board[i] == board[k - 1]) {
				return 0;
			} else if (Math.pow(k - 1 - i, 2) == Math.pow(board[k - 1] - board[i], 2)) {
				return 0;
			}
		}
		
		if (k == N) {
			return 1;
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			board[k] = i;
			count += find(k + 1);
		}
		return count;
	}

}
