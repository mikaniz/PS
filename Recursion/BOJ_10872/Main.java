import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fac(N));
	}
	
	public static int fac(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * fac(n - 1);
	}

}
