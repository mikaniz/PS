import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (N > 1) {
			for (int i = 2; i <= N; i++) {
				if (N % i == 0) {
					bw.write(String.valueOf(i) + "\n");
					N /= i;
					break;
				}
			}
		}
		bw.flush();
		bw.close();
	}

}
