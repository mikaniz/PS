import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {
	
	private int x;
	private int time;
	
	public Point(int x, int time) {
		this.x = x;
		this.time = time;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getTime() {
		return this.time;
	}
	
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		System.out.println(bfs(N, K));
	}
	
	public static int bfs(int N, int K) {
		int[] time = new int[100001];
		boolean[] visited = new boolean[100001];
		
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(N, 0));
		visited[N] = true;
		
		while (!q.isEmpty()) {
			Point point = q.poll();
			int x = point.getX();
			int t = point.getTime();
			
			if (x - 1 >= 0) {
				if (visited[x - 1]) {
					if (time[x - 1] > t + 1) {
						q.offer(new Point(x - 1, t + 1));
						time[x - 1] = t + 1;
					}
				} else {
					q.offer(new Point(x - 1, t + 1));
					visited[x - 1] = true;
					time[x - 1] = t + 1;
				}
			}
			if (x + 1 < 100001) {
				if (visited[x + 1]) {
					if (time[x + 1] > t + 1) {
						q.offer(new Point(x + 1, t + 1));
						time[x + 1] = t + 1;
					}
				} else {
					q.offer(new Point(x + 1, t + 1));
					visited[x + 1] = true;
					time[x + 1] = t + 1;
				}
			}
			if (x * 2 < 100001) {
				if (visited[x * 2]) {
					if (time[x * 2] > t + 1) {
						q.offer(new Point(x * 2, t + 1));
						time[x * 2] = t + 1;
					}
				} else {
					q.offer(new Point(x * 2, t + 1));
					visited[x * 2] = true;
					time[x * 2] = t + 1;
				}
			}
		}
		
		return time[K];
	}

}
