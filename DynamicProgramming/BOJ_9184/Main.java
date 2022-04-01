import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
	
	static HashMap<String, Integer> values = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		while(a != -1 || b != -1 || c != -1) {
			String function = "w(" + a + ", " + b + ", " + c + ")";
			bw.write(function + " = " + getValue(function, a, b, c) + "\n");
			
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		bw.flush();
		bw.close();
	}
	
	public static int getValue(String function, int a, int b, int c) {
		if (!values.containsKey(function)) {
			if (a <= 0 || b <= 0 || c <= 0) {
				values.put(function, 1);
			} else if (a > 20 || b > 20 || c > 20) {
				String function_20 = "w(" + 20 + ", " + 20 + ", " + 20 + ")";
				int v = getValue(function_20, 20, 20, 20);
				
				values.put(function, v);
			} else if (a < b && b < c) {
				String function_1 = "w(" + a + ", " + b + ", " + (c - 1) + ")";
				int v1 = getValue(function_1, a, b, c - 1);
				
				String function_2 = "w(" + a + ", " + (b - 1) + ", " + (c - 1) + ")";
				int v2 = getValue(function_2, a, b - 1, c - 1);

				String function_3 = "w(" + a + ", " + (b - 1) + ", " + c + ")";
				int v3 = getValue(function_3, a, b - 1, c);
				
				values.put(function, v1 + v2 - v3);
			} else {
				String function_1 = "w(" + (a - 1) + ", " + b + ", " + c + ")";
				int v1 = getValue(function_1, a - 1, b, c);
				
				String function_2 = "w(" + (a - 1) + ", " + (b - 1) + ", " + c + ")";
				int v2 = getValue(function_2, a - 1, b - 1, c);

				String function_3 = "w(" + (a - 1) + ", " + b + ", " + (c - 1) + ")";
				int v3 = getValue(function_3, a - 1, b, c - 1);
				
				String function_4 = "w(" + (a - 1) + ", " + (b - 1) + ", " + (c - 1) + ")";
				int v4 = getValue(function_4, a - 1, b - 1, c - 1);
				
				values.put(function, v1 + v2 + v3 - v4);
			}
		}
		return values.get(function);
	}

}
