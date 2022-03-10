import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int change = 1000 - sc.nextInt();
		sc.close();
		
		int count = 0;
		int[] coins = {500, 100, 50, 10, 5, 1};
		for (int coin : coins) {
			count += change / coin;
			change -= change / coin * coin;
		}
		
		System.out.println(count);
	}

}
