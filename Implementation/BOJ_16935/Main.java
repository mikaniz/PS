import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[] operations = new int[R];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			operations[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int operation : operations) {
			arr = operateArr(arr, N, M, operation);
			N = arr.length;
			M = arr[0].length;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(String.valueOf(arr[i][j]) + " ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	public static int[][] operateArr(int[][] arr, int N, int M, int operation) {
		int[][] result = new int[N][M];
		
		switch (operation) {
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					result[i][j] = arr[N - 1 - i][j];
				}
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					result[i][j] = arr[i][M - 1 - j];
				}
			}
			break;
		case 3:
			result = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					result[i][j] = arr[N - 1 - j][i];
				}
			}
			break;
		case 4:
			result = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					result[i][j] = arr[j][M - 1 - i];
				}
			}
			break;
		case 5:
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					result[i][j] = arr[N / 2 + i][j];
				}
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					result[i][j] = arr[i][j - M / 2];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					result[i][j] = arr[i][M / 2 + j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					result[i][j] = arr[i - N / 2][j];
				}
			}
			break;
		case 6:
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					result[i][j] = arr[i][M / 2 + j];
				}
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					result[i][j] = arr[N / 2 + i][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					result[i][j] = arr[i - N / 2][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					result[i][j] = arr[i][j - M / 2];
				}
			}
			break;
		}
		
		return result;
	}

}
