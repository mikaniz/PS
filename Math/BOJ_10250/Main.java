import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(N % H != 0 ? N % H : H));
			bw.write(String.format("%02d", N % H != 0 ? N / H + 1 : N / H));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
