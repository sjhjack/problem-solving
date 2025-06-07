import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 1_000_000;    // 임의의 큰 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for(int i = 5; i <= N; i += 5) {
            dp[i] = dp[i - 5] + 1;
        }

        for(int i = 2; i <= N; i++) {
            dp[i] = Math.min(dp[i], dp[i - 2] + 1);
        }

        System.out.print(dp[N] < MAX ? dp[N] : -1);
    }
}