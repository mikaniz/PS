import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st;
			
			Integer[][] scores = new Integer[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				scores[i][0] = Integer.parseInt(st.nextToken());
				scores[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(scores, (o1, o2) -> {
				return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
			});
			
			int count = 1;
			int min = scores[0][1];
			for (int i = 1; i < N; i++) {
				if (min > scores[i][1]) {
					count++;
					min = scores[i][1];
				}
			}
			
			System.out.println(count);
		}
	}

}
