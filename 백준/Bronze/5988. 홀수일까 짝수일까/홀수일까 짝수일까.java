import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			int num = s.charAt(s.length() - 1) - '0';

			if(num % 2 == 0) {
				ans.append("even").append("\n");
			} else {
				ans.append("odd").append("\n");
			}
		}

		System.out.print(ans);
	}
}
