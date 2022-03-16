import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf((int) Math.pow(2, K) - 1) + "\n");
		hanoi(K, 1, 3, 2, bw);
		bw.flush();
		bw.close();
	}
	
	public static void hanoi(int K, int from, int to, int mid, BufferedWriter bw) throws IOException {
		if (K < 1) {
			return;
		}
		
		hanoi(K - 1, from, mid, to, bw);
		bw.write(String.valueOf(from) + " " + String.valueOf(to) + "\n");
		hanoi(K - 1, mid, to, from, bw);
	}

}
