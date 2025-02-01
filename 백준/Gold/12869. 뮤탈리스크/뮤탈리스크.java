import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 10000;
    static final int[][] attack = {
        {9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9},
        {1, 9, 3}, {1, 3, 9}
    };

    static int N;
    static int[][][] dp;
    static int[] scv;
    
    public static void main(String[] args) throws IOException {
        init();
        System.out.print(dfs(scv[0], scv[1], scv[2]));
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[61][61][61];
        scv = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }
    }

    // dp[0][0][0]까지의 최소 깊이를 계산
    static int dfs(int scv1, int scv2, int scv3) {
        if(dp[scv1][scv2][scv3] != 0) {
            return dp[scv1][scv2][scv3];
        }
        
        if(scv1 == 0 && scv2 == 0 && scv3 == 0) {
            return 0;
        }

        dp[scv1][scv2][scv3] = MAX;

        for(int i = 0; i < attack.length; i++) {
            int next1 = Math.max(scv1 - attack[i][0], 0);
            int next2 = Math.max(scv2 - attack[i][1], 0);
            int next3 = Math.max(scv3 - attack[i][2], 0);

            dp[scv1][scv2][scv3] = Math.min(dp[scv1][scv2][scv3], dfs(next1, next2, next3) + 1);
        }

        return dp[scv1][scv2][scv3];
    }
}
