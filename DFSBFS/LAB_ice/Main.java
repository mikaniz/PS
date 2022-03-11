import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	public static ArrayList<ArrayList<Integer>> tray;
	public static int N;
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tray = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			tray.add(new ArrayList<Integer>());
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				tray.get(i).add(data.charAt(j) - '0');
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dfs(i, j)) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

	public static boolean dfs(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) {
			return false;
		}
		if (tray.get(x).get(y) == 0) {
			tray.get(x).set(y, 1);

			dfs(x - 1, y);
			dfs(x + 1, y);
			dfs(x, y - 1);
			dfs(x, y + 1);

			return true;
		}
		return false;
	}

}
