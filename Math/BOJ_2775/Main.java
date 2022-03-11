import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] count = new int[15][15];
		for (int i = 1; i < 15; i++) {
			count[i][1] = 1;
			count[0][i] = i;
		}
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				count[i][j] = count[i - 1][j] + count[i][j - 1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			bw.write(String.valueOf(count[k][n]) + "\n");
		}
		bw.flush();
		bw.close();
	}

}
