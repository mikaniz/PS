import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int count = 0;
		int N = 1;
		while (N < n) {
			count++;
			N += count * 6;
		}
		System.out.println(++count);
	}

}
