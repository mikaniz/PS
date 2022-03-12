import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		sc.close();
		
		int l1 = Math.min(x, w - x);
		int l2 = Math.min(y, h - y);
		double l3 = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double l4 = Math.sqrt(Math.pow(w - x, 2) + Math.pow(h - y, 2));
		
		System.out.println((int) Math.min(Math.min(l1, l2), Math.min(l3, l4)));
	}

}
