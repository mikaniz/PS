import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] memo = new int[N + 1];
		for (int i = 2; i < N + 1; i++) {
			if (i == 2) {
				memo[i] = 1;
			} else {
				int a = i % 3 == 0 ? memo[i / 3] + 1 : i;
				int b = i % 2 == 0 ? memo[i / 2] + 1 : i;
				int c = memo[i - 1] + 1;
				
				memo[i] = Math.min(Math.min(a, b), c);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(memo[N]) + "\n");
		bw.flush();
		bw.close();
	}

}
