import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	static class Member {
		int age;
		String name;

		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Member[] members = new Member[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		Arrays.sort(members, (o1, o2) -> {
			return o1.age - o2.age;
		});

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (Member member : members) {
			bw.write(String.valueOf(member.age) + " " + member.name + "\n");
		}
		bw.flush();
		bw.close();
	}

}
