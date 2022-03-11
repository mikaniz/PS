import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Point {
	
	private int x;
	private int y;
	private int day;
	
	public Point(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getDay() {
		return this.day;
	}
	
}

public class Main {

	public static int[][] graph;
	public static int M;
	public static int N;
	public static int H;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		graph = new int[N * H][M];
		for (int i = 0; i < N * H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int[] dx = {-1, 1, 0, 0, -N, N};
		int[] dy = {0, 0, -1, 1, 0, 0};
		
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < N * H; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 1) {
					q.offer(new Point(i, j, 0));
				}
			}
		}
		
		int day = 0;
		while (!q.isEmpty()) {
			Point point = q.poll();
			int x = point.getX();
			int y = point.getY();
			day = point.getDay();
			
			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N * H || ny < 0 || ny >= M) {
					continue;
				}
				if (graph[nx][ny] == 0) {
					graph[nx][ny] = 1;
					q.offer(new Point(nx, ny, day + 1));
				}
			}
		}
		
		for (int i = 0; i < N * H; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					return -1;
				}
			}
		}
		
		return day;
	}

}
