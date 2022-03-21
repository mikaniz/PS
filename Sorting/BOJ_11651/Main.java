import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static class Point {
		
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Point> points = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(points, (o1, o2) -> {
			return o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y;
		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (Point point : points) {
			bw.write(String.valueOf(point.x) + " " + String.valueOf(point.y) + "\n");
		}
		bw.flush();
		bw.close();
	}

}
