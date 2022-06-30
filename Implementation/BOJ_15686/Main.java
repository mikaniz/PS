import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	static ArrayList<Integer> homePosition;
	static ArrayList<Integer> chickenPosition;
	static int[][] map;
	static int N;
	static int M;
	static int chickenDist = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		homePosition = new ArrayList<Integer>();
		chickenPosition = new ArrayList<Integer>();
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < N; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
				
				if (map[x][y] == 1) {
					homePosition.add(x * N + y);
				} else if (map[x][y] == 2) {
					chickenPosition.add(x * N + y);
				}
			}
		}
		
		selectChicken(0, chickenPosition.size(), 0, new ArrayList<Integer>());
		
		bw.write(chickenDist + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void selectChicken(int n, int len, int k, ArrayList<Integer> selectedChicken) {
		if (n == M) {
			calChickenDist(selectedChicken);
			return;
		}
		
		for (int i = k; i < len; i++) {
			selectedChicken.add(chickenPosition.get(i));
			selectChicken(n + 1, len, i + 1, selectedChicken);
			selectedChicken.remove(n);
		}
	}
	
	public static void calChickenDist(ArrayList<Integer> selectedChicken) {
		int result = 0;
		
		for (int home : homePosition) {
			int homeX = home / N;
			int homeY = home % N;
			
			int minDist = Integer.MAX_VALUE;
			for (int chicken : selectedChicken) {
				int chickenX = chicken / N;
				int chickenY = chicken % N;
				
				int dist = Math.abs(homeX - chickenX) + Math.abs(homeY - chickenY);
				if (dist < minDist) {
					minDist = dist;
				}
			}
			
			result += minDist;
		}
		
		if (result < chickenDist) {
			chickenDist = result;
		}
	}

}
