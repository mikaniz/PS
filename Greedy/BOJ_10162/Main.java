import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.close();
		
		if (T % 10 == 0) {
			int[] times = {300, 60, 10};
			for (int time : times) {
				System.out.print(T / time + " ");
				T -= T /time * time;
			}
		} else {
			System.out.println(-1);
		}
	}

}
