import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 1_000_000;
    
    static int N, M;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        // [][][0], [][][1], [][][2]는 각각
        // 왼쪽, 가운데, 오른쪽에서 현재 칸으로 왔을 때의 최소 연료 값
        int[][][] dp = new int[N][M][3];
        int ans = MAX;

        for(int j = 0; j < M; j++) {
            for(int k = 0; k < 3; k++) {
                dp[0][j][k] = arr[0][j];
            }
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                dp[i][j][0] = arr[i][j] + 
                    (j - 1 >= 0 ? 
                        Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) :
                        MAX
                    );

                dp[i][j][1] = arr[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);

                dp[i][j][2] = arr[i][j] + 
                    (j + 1 < M ? 
                        Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) :
                        MAX
                    );
            }
        }

        for(int j = 0; j < M; j++) {
            for(int k = 0; k < 3; k++) {
                ans = Math.min(ans, dp[N - 1][j][k]);
            }
        }

        System.out.print(ans);
    }
}
