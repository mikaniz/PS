import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[] ropes = new Integer[N];
		for (int i = 0; i < N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ropes, Collections.reverseOrder());
		
		int count = 0;
		int max = 0;
		for (int rope : ropes) {
			count++;
			if (rope * count > max) {
				max = rope * count;
			}
		}
		
		System.out.println(max);
	}

}
