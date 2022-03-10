import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		int len = N.length();
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) {
			nums[i] = N.charAt(i) - '0';
		}
		
		Arrays.sort(nums);

		if (nums[0] == 0) {
			int sum = 0;
			for (int num : nums) {
				sum += num;
			}
			
			if (sum % 3 == 0) {
				for (int i = len - 1; i >= 0; i--) {
					System.out.print(nums[i]);
				}
			} else {
				System.out.println(-1);
			}
		} else {
			System.out.println(-1);
		}
	}

}
