import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int gap = n;
			int p1 = 0;
			for (int i = 2; i <= n / 2; i++) {
				if (isPrime(i) && isPrime(n - i)) {
					if (n - i - i < gap) {
						gap = n - i - i;
						p1 = i;
					}
				}
			}
			
			bw.write(String.valueOf(p1) + " " + String.valueOf(n - p1) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
