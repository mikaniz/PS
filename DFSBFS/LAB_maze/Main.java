import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}

public class Main {

	public static int[][] maze;
	public static int N;
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = data.charAt(j) - '0';
			}
		}

		System.out.println(bfs(0, 0));
	}

	public static int bfs(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		while (!q.isEmpty()) {
			Point point = q.poll();
			x = point.getX();
			y = point.getY();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (maze[nx][ny] == 1) {
					maze[nx][ny] += maze[x][y];
					q.offer(new Point(nx, ny));
				}
			}
		}

		return maze[N - 1][M - 1];
	}

}
