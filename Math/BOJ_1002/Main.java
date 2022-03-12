import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			int d = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			if (d == 0 && r1 == r2) {
				bw.write(String.valueOf(-1) + "\n");
			} else if (Math.pow(r1 + r2, 2) < d) {
				bw.write(String.valueOf(0) + "\n");
			} else if (Math.pow(r1 + r2, 2) == d) {
				bw.write(String.valueOf(1) + "\n");
			} else if (Math.pow(r1 - r2, 2) > d) {
				bw.write(String.valueOf(0) + "\n");
			} else if (Math.pow(r1 - r2, 2) == d){
				bw.write(String.valueOf(1) + "\n");
			} else {
				bw.write(String.valueOf(2) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
