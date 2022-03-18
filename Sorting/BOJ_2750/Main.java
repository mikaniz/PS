import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
	
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		temp = new int[N];
		mergeSort(nums, 0, N - 1);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(nums[i]) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void mergeSort(int[] nums, int left, int right) {
		if (left == right) {
			return;
		}
		
		int mid = (left + right) / 2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid + 1, right);
		merge(nums, left, right);
	}
	
	public static void merge(int[] nums, int left, int right) {
		int mid = (left + right) / 2;
		
		int l = left;
		int r = mid + 1;
		int index = left;
		while (l <= mid && r <= right) {
			temp[index++] = nums[l] < nums[r] ? nums[l++] : nums[r++];
		}
		while (l <= mid) {
			temp[index++] = nums[l++];
		}
		while (r <= right) {
			temp[index++] = nums[r++];
		}
		
		for (int i = left; i <= right; i++) {
			nums[i] = temp[i];
		}
	}

}
