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
	public static int N;
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
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
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
					continue;
				}
				if (graph[nx][ny] == 0) {
					graph[nx][ny] = 1;
					q.offer(new Point(nx, ny, day + 1));
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 0) {
					return -1;
				}
			}
		}
		
		return day;
	}

}
