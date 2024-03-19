import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= 9; i++) {
			ans.append(N).append(" * ").append(i).append(" = ").append(N * i).append("\n");
		}
		
		System.out.print(ans);
	}
}
