import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] sides;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			sides = new int[3];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 3; i++) {
				sides[i] = Integer.parseInt(st.nextToken());
			}
			
			if (sides[0] == 0) {
				break;
			}
			
			Arrays.sort(sides);
			
			if (Math.pow(sides[2], 2) == Math.pow(sides[0], 2) + Math.pow(sides[1], 2)) {
				bw.write("right\n");
			} else {
				bw.write("wrong\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
