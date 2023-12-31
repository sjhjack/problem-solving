import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] arr;
	static int[][] dp;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
	
	static int solve(int left, int right, int cnt) {
		// 한쪽에서 다 뽑은 경우 보려면 left == right 탐색해야됨
		if(left > right) {
			return 0;
		}
		
		if(dp[left][right] != 0) {
			return dp[left][right];
		}
		
		dp[left][right] = Math.max(solve(left+1, right, cnt+1) + arr[left]*cnt, 
								   solve(left, right-1, cnt+1) + arr[right]*cnt);
		
		return dp[left][right];
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve(0, N-1, 1);
		System.out.print(dp[0][N-1]);
	}
}
