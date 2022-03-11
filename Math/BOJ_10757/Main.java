import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		ArrayList<Integer> result = new ArrayList<>();
		int lenA = A.length();
		int lenB = B.length();
		int up = 0;
		for (int i = 0; i < Math.max(lenA, lenB); i++) {
			int a = i < lenA ? A.charAt(lenA - 1 - i) - '0' : 0;
			int b = i < lenB ? B.charAt(lenB - 1 - i) - '0' : 0;
			int sum = a + b + up;
			result.add(sum % 10);
			up = sum / 10;
		}
		if (up > 0) {
			result.add(up);
		}
		
		int len = result.size();
		for (int i = 0; i < len; i++) {
			System.out.print(result.get(len - 1 - i));
		}
		System.out.println();
	}

}
