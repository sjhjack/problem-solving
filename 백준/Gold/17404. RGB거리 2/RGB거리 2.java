import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int MAX = 10_000_000;
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		int[][] dp;
		int ans = MAX;

		for(int k = 0; k < 3; k++){
			dp = new int[N][3];
			// 첫번째 층 색 고정
			for(int i = 0; i < 3; i++){
				if(i == k) dp[0][i] = arr[0][i];
				else dp[0][i] = MAX;	// dp[1][i]는 무조건 dp[0][k]를 포함한다.
			}

			for(int i = 1; i < N; i++){
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}

			for(int i = 0; i < 3; i++){
				if(i == k) continue;
				ans = Math.min(ans, dp[N-1][i]);
			}
		}

		System.out.print(ans);
	}
}
