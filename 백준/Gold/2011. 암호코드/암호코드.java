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

        char[] tmp = br.readLine().toCharArray();
        N = tmp.length;
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = tmp[i] - '0';
        }
    }

    static void solve() {
        int[][] dp = new int[N][3];

        if(arr[0] > 0) {
            dp[0][0] = 1;
            dp[0][1] = 1;
        }

        for(int i = 1; i < N; i++) {
            if(arr[i] > 0) {
                dp[i][1] = dp[i - 1][0];
            }

            int number = arr[i - 1] * 10 + arr[i];
            if(arr[i - 1] > 0 && (1 <= number && number <= 26)) {
                dp[i][2] = dp[i - 1][1];
            }

            dp[i][0] = (dp[i][1] + dp[i][2]) % 1000000;
        }

        System.out.print(dp[N - 1][0]);
    }
}
