import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken());
			if (map.containsKey(card)) {
				map.replace(card, map.get(card) + 1);
			} else {
				map.put(card, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (map.containsKey(num)) {
				bw.write(String.valueOf(map.get(num)) + " ");
			} else {
				bw.write(String.valueOf(0) + " ");
			}
		}
		bw.newLine();
		bw.flush();
		bw.close();
	}

}
