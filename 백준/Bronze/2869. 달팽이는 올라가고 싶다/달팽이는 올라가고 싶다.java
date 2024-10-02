import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int ans = (V - B) / (A - B);    // 정상에 도착했을 때 안 내려오게 미리 빼준다.

        if((V - B) % (A - B) > 0) {
            ans++;
        }
		
		System.out.print(ans);
	}
}
