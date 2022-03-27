import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int[][] board = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		fill(0, 0);
	}

	public static void fill(int x, int y) throws IOException {
		if (y == 9) {
			fill(x + 1, 0);
			return;
		}
		if (x == 9) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					bw.write(String.valueOf(board[i][j]) + " ");
				}
				bw.newLine();
			}
			bw.flush();
			bw.close();
			System.exit(0);
		}

		if (board[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (check(x, y, i)) {
					board[x][y] = i;
					fill(x, y + 1);
				}
			}
			board[x][y] = 0;
			return;
		}

		fill(x, y + 1);
	}

	public static boolean check(int x, int y, int k) {
		for (int i = 0; i < 9; i++) {
			if (board[x][i] == k || board[i][y] == k) {
				return false;
			}
		}

		int m = x / 3 * 3;
		int n = y / 3 * 3;
		for (int i = m; i < m + 3; i++) {
			for (int j = n; j < n + 3; j++) {
				if (board[i][j] == k) {
					return false;
				}
			}
		}

		return true;
	}

}
