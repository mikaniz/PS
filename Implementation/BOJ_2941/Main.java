import java.util.Scanner;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		sc.close();
		
		HashSet<String> set = new HashSet<>();
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");
		set.add("z=");
		
		int count = 0;
		String pre = "";
		int len = line.length();
		for (int i = 0; i < len; i++) {
			char now = line.charAt(i);
			
			if (set.contains(pre + now)) {
				count++;
				pre = "";
			} else if ("dz".equals(pre + now)) {
				pre += now;
			} else {
				count += pre.length();
				pre = "" + now;
			}
		}
		count += pre.length();
		
		System.out.println(count);
	}

}
