import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(nums);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += nums.get(i);
		}
		bw.write(String.valueOf(Math.round(sum / N)) + "\n");
		
		bw.write(String.valueOf(nums.get(N / 2)) + "\n");
		
		if (N > 1) {
			HashMap<Integer, Integer> count = new HashMap<>();
			for (int i = 0; i < N; i++) {
				if (count.containsKey(nums.get(i))) {
					count.replace(nums.get(i), count.get(nums.get(i)) + 1);
				} else {
					count.put(nums.get(i), 1);
				}
			}
			
			List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(count.entrySet());
			entryList.sort((o1, o2) -> o1.getValue() == o2.getValue() ? o1.getKey() - o2.getKey() : o2.getValue() - o1.getValue());
			
			bw.write(String.valueOf(entryList.get(0).getValue() == entryList.get(1).getValue() ? entryList.get(1).getKey() : entryList.get(0).getKey()) + "\n");
		} else {
			bw.write(String.valueOf(nums.get(0)) + "\n");
		}
		
		bw.write(String.valueOf(nums.get(N - 1) - nums.get(0)) + "\n");
		
		bw.flush();
		bw.close();
	}

}
