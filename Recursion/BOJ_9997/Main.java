import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	
	static int[] words;
	static int N;
	static int count = 0;
	static int full = (1 << 26) - 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		words = new int[N];
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			int len = word.length();
			for (int j = 0; j < len; j++) {
				words[i] |= 1 << word.charAt(j) - 'a';
			}
		}
		
		countSentence(0, 0);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
	
	public static void countSentence(int k, int selected) {
		if (k > N) {
			return;
		}
		
		if (selected == full) {
			count += Math.pow(2, N - k);
			return;
		}
		
		for (int i = k; i < N; i++) {
			countSentence(i + 1, selected | words[i]);
		}
	}

}
