import java.io.*;

class Main {
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        int[][] dp = new int[N][3];

        dp[0][0] = 0;        // 마시지 않은 경우
        dp[0][1] = arr[0];   // 한 잔 마신 경우
        dp[0][2] = arr[0];   // 두 잔 연속으로 마신 경우

        if(N >= 2) {
            dp[1][0] = arr[0];
            dp[1][1] = arr[1];
            dp[1][2] = arr[0] + arr[1];    
        }
        
        for(int i = 2; i < N; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] = Math.max(dp[i-2][0], Math.max(dp[i-2][1], dp[i-2][2])) + arr[i];
            dp[i][2] = dp[i-1][1] + arr[i];
        }

        int ans = 0;

        if(N >= 2) {
            for(int j = 0; j < 3; j++) {
                ans = Math.max(ans, dp[N-2][j]);
            }
        }
        
        for(int j = 0; j < 3; j++) {
            ans = Math.max(ans, dp[N-1][j]);
        }

        System.out.print(ans);
    }
}
