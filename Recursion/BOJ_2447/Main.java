import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] stars = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				stars[i][j] = ' ';
			}
		}
		make_star(stars, N, 0, 0);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(stars[i][j]);
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	public static void make_star(char[][] stars, int N, int x, int y) {
		if (N == 1) {
			stars[x][y] = '*';
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != 1 || j != 1) {
					make_star(stars, N / 3, x + i * (N / 3), y + j * (N / 3));
				}
			}
		}
	}

}
