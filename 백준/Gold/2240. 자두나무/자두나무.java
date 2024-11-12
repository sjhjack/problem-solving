import java.io.*;
import java.util.*;

class Main {
    static int T, W;
    static int[] arr;
    
    public static void main(String[] args) throws IOException{
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[T + 1];

        for(int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        // dp[초][나무][이동횟수] = 받을 수 있는 자두 개수
        int[][][] dp = new int[T + 1][3][W + 1];
        int ans = 0;

        dp[1][1][0] = arr[1] == 1 ? 1 : 0;
        dp[1][2][0] = 0;
        dp[1][1][1] = 0;
        dp[1][2][1] = arr[1] == 2 ? 1 : 0;

        for(int t = 1; t < T; t++) {
            for(int w = 0; w <= W && w <= t; w++) {
                int one = arr[t+1] == 1 ? 1 : 0;
                int two = arr[t+1] == 2 ? 1 : 0;
                
                dp[t+1][1][w] = Math.max(dp[t+1][1][w], dp[t][1][w] + one);
                dp[t+1][2][w] = Math.max(dp[t+1][2][w], dp[t][2][w] + two);
                
                if(w + 1 <= W) {
                    dp[t+1][1][w+1] = Math.max(dp[t+1][1][w+1], dp[t][2][w] + one);
                    dp[t+1][2][w+1] = Math.max(dp[t+1][2][w+1], dp[t][1][w] + two);
                }
            }
        }

        for(int i = 0; i <= W; i++) {
            ans = Math.max(ans, Math.max(dp[T][1][i], dp[T][2][i]));
        }

        System.out.print(ans);
    }
}
