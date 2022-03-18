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
		int count = 0;
		for (int i = 0; count < N; i++) {
			if (isEnd(i)) {
				count++;
			}
			if (count == N) {
				bw.write(String.valueOf(i));
			}
		}
		bw.newLine();
		bw.flush();
		bw.close();
	}
	
	public static boolean isEnd(int n) {
		int count = 0;
		while (n > 0) {
			if (n % 10 == 6) {
				count++;
			} else {
				count = 0;
			}
			
			if (count >= 3) {
				return true;
			}
			
			n /= 10;
		}
		return false;
	}

}
