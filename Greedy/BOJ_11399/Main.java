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
		int[] times = new int[N];
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		int sum = 0;
		Arrays.sort(times);
		for (int i = 0; i < N; i++) {
			time += sum;
			time += times[i];
			sum += times[i];
		}
		
		System.out.println(time);
	}

}
