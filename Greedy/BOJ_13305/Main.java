import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		long[] roads = new long[N - 1];
		for (int i = 0; i < N - 1; i++) {
			roads[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		Long[] stations = new Long[N];
		for (int i = 0; i < N; i++) {
			stations[i] = Long.parseLong(st.nextToken());
		}
		
		long min = stations[0];
		long[] choice = new long[N - 1];
		for (int i = 0; i < N - 1; i++) {
			if (stations[i] < min) {
				min = stations[i];
			}
			choice[i] = min;
		}
		
		long price = 0;
		for (int i = 0; i < N - 1; i++) {
			price += roads[i] * choice[i];
		}
		
		System.out.println(price);
	}

}
