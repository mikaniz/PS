import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		sc.close();
		
		System.out.println(String.format("%.06f", Math.pow(R, 2) * Math.PI));
		System.out.println(String.format("%.06f", Math.pow(R, 2) * 2));
	}

}
