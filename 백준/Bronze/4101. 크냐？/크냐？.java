import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder ans = new StringBuilder();

		while(true){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(a + b == 0) break;

			if(a > b) {
				ans.append("Yes\n");
			} else {
				ans.append("No\n");
			}
		}

		System.out.print(ans);
	}
}
