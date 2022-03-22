import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int len_o1 = o1.length();
				int len_o2 = o2.length();
				if (len_o1 == len_o2) {
					for (int i = 0; i < len_o1; i++) {
						char c1 = o1.charAt(i);
						char c2 = o2.charAt(i);
						if (c1 != c2) {
							return c1 - c2;
						}
					}
				}
				return len_o1 - len_o2;
			}
		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word = "";
		for (int i = 0; i < N; i++) {
			if (!words[i].equals(word)) {
				bw.write(words[i] + "\n");
				word = words[i];
			}
		}
		bw.flush();
		bw.close();
	}

}
