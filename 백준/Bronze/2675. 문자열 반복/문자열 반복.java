import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder ans = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			char[] arr = st.nextToken().toCharArray();

			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < num; j++) {
					ans.append(arr[i]);
				}
			}
			ans.append("\n");
		}

		System.out.print(ans);
	}
}
