import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
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

	static int[][] map;
	static ArrayList<Point> viruses;
	static int N;
	static int M;
	static int safe = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		viruses = new ArrayList<Point>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				
				if (map[n][m] == 2) {
					viruses.add(new Point(n, m));
				}
			}
		}
		
		buildWalls(map, 0, 0);
		
		bw.write(safe + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void buildWalls(int[][] map, int n, int position) {
		if (n == 3) {
			spreadViruses(map);
			return;
		}
		
		for (int p = position; p < N * M; p++) {
			int x = p / M;
			int y = p % M;
			
			if (map[x][y] == 0) {
				map[x][y] = 1;
				buildWalls(map, n + 1, p + 1);
				map[x][y] = 0;
			}
		}
	}
	
	public static void spreadViruses(int[][] map) {
		int[][] tempMap = new int[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tempMap[n][m] = map[n][m];
			}
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		Queue<Point> q = new LinkedList<>();
		for (Point virus : viruses) {
			q.offer(virus);
		}
		
		while (!q.isEmpty()) {
			Point point = q.poll();
			int x = point.getX();
			int y = point.getY();
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				
				if (tempMap[nx][ny] == 0) {
					tempMap[nx][ny] = 2;
					q.offer(new Point(nx, ny));
				}
			}
		}
		
		countSafe(tempMap);
	}
	
	public static void countSafe(int[][] tempMap) {
		int count = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (tempMap[n][m] == 0) {
					count++;
				}
			}
		}
		
		if (count > safe) {
			safe = count;
		}
	}

}
