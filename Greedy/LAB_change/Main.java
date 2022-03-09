import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int change = sc.nextInt();
		sc.close();
		
		int[] coins = {500, 100, 50, 10};
		int count = 0;
		for (int coin : coins) {
			count += change / coin;
			change %= coin;
		}
		
		System.out.println(count);
	}

}
