import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		int count = 0;
		while (N > 1) {
			if (N % K != 0) {
				count += N % K;
				N -= K;
			}
			
			count += 1;
			N /= K;
		}
		
		System.out.println(count);
	}

}
