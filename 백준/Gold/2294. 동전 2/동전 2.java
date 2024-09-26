import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] arr;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[K + 1];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }        
    }

    static void solve() {
        Arrays.sort(arr);
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            for(int k = arr[i]; k <= K; k++) {
                dp[k] = Math.min(dp[k], dp[k-arr[i]] + 1);
            }
        }

        if(dp[K] == 10001) {
            System.out.print(-1);
        } else {
            System.out.print(dp[K]);
        }
    }
}
