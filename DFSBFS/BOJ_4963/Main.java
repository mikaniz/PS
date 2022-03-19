import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<ArrayList<Integer>> island;
	static int w;
	static int h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		while(w != 0 && h != 0) {
			island = new ArrayList<>();
			for (int i = 0; i < h; i++) {
				island.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					island.get(i).add(Integer.parseInt(st.nextToken()));
				}
			}
			
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (dfs(i, j)) {
						count++;
					}
				}
			}
			bw.write(String.valueOf(count) + "\n");
			
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		bw.flush();
		bw.close();
	}
	
	public static boolean dfs(int x, int y) {
		if (x < 0 || x >= h || y < 0 || y >= w) {
			return false;
		}
		if (island.get(x).get(y) == 1) {
			island.get(x).set(y, 0);
			
			dfs(x - 1, y);
			dfs(x + 1, y);
			dfs(x, y - 1);
			dfs(x, y + 1);
			dfs(x - 1, y - 1);
			dfs(x - 1, y + 1);
			dfs(x + 1, y - 1);
			dfs(x + 1, y + 1);
			
			return true;
		}
		return false;
	}

}
