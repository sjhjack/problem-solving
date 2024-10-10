import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        // dp[i][j][k] : (i,j)에서 k방향으로 가기위한 최솟값
        int[][][] dp = new int[N][M][3];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i = 0; i < M; i++) {
            dp[0][i][0] = arr[0][i];
            dp[0][i][1] = arr[0][i];
            dp[0][i][2] = arr[0][i];
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(j == 0) {
                    dp[i][j][1] = dp[i-1][j+1][0] + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j][1], dp[i-1][j+1][0]) + arr[i][j];
                } else if(j == M - 1) {
                    dp[i][j][1] = dp[i-1][j-1][2] + arr[i][j];
                    dp[i][j][0] = Math.min(dp[i-1][j-1][2], dp[i-1][j][1]) + arr[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][2], dp[i-1][j][1]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j-1][2], dp[i-1][j+1][0]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j][1], dp[i-1][j+1][0]) + arr[i][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < 3; j++) {
                ans = Math.min(dp[N-1][i][j], ans);
            }
        }

        System.out.print(ans);
    }
}
