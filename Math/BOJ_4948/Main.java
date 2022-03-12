import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		while (n != 0) {
			int count = 0;
			for (int i = n + 1; i <= n * 2; i++) {
				boolean isPrime = true;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					count++;
				}
			}
			bw.write(String.valueOf(count) + "\n");
			n = Integer.parseInt(br.readLine());
		}
		bw.flush();
		bw.close();
	}

}
