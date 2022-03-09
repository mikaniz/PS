import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] fear = new int[N];
		for (int i = 0; i < N; i++) {
			fear[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int group = 0;
		Arrays.sort(fear);
		for (int i = 0; i < N; i++) {
			group++;
			if (group >= fear[i]) {
				count++;
				group = 0;
			}
		}
		
		System.out.println(count);
	}

}
