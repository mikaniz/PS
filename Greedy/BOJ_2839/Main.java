import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int count = 0;
		int five = N / 5;
		for (int i = five; i >= 0; i--) {
			if (N - i * 5 == 0) {
				count = i;
				break;
			} else if ((N - i * 5) % 3 == 0) {
				count = i + (N - i * 5) / 3;
				break;
			}
		}
		
		System.out.println(count != 0 ? count : -1);
	}

}
