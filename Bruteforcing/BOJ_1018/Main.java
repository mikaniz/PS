import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		int min = N * M;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int correction = findCorrection(board, i, j);
				if (correction < min) {
					min = correction;
				}
			}
		}
		System.out.println(min);
	}
	
	public static int findCorrection(char[][] board, int x, int y) {
		int startB = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					if (board[x + i][y + j] != 'B') {
						startB++;
					}
				} else {
					if (board[x + i][y + j] != 'W') {
						startB++;
					}
				}
			}
		}
		
		int startW = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					if (board[x + i][y + j] != 'W') {
						startW++;
					}
				} else {
					if (board[x + i][y + j] != 'B') {
						startW++;
					}
				}
			}
		}
		
		return startB < startW ? startB : startW;
	}

}
