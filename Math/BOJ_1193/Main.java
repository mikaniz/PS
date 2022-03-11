import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		sc.close();
		
		int sum = 0;
		int i;
		for (i = 1; ; i++) {
			sum += i;
			if (X <= sum) {
				break;
			}
		}
		
		X -= sum - i;
		int m;
		int n;
		if (i % 2 == 0) {
			m = i - X + 1;
			n = i - m + 1;
		} else {
			n = i - X + 1;
			m = i - n + 1;
		}
		System.out.println(n + "/" + m);
	}

}
