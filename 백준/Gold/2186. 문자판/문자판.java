import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};    // 상하좌우
    static final int[] dc = {0,0,-1,1};
    
    static int N, M, K;
    static char[][] arr;
    static char[] target;
    static int[][][] dp;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        target = br.readLine().toCharArray();
        dp = new int[N][M][target.length];
    }

    static void solve() {
        int ans = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == target[0]) {
                    int result = dfs(i, j, 0);

                    if(result > 0) {
                        ans += result;
                    }
                }
            }
        }

        System.out.print(ans);
    }

    static int dfs(int row, int col, int step) {
        // 마지막 문자에 도달한 경우
        if(step == target.length - 1) {
            return 1;
        }

        // 이미 탐색한 경우
        if(dp[row][col][step] != 0) {
            return dp[row][col][step];
        }

        // 처음 탐색하는 경우
        for(int d = 0; d < 4; d++) {
            for(int k = 1; k <= K; k++) {
                int nr = row + dr[d] * k;
                int nc = col + dc[d] * k;

                if(outOfBound(nr, nc)) {
                    break;
                }
                if(arr[nr][nc] != target[step + 1]) {
                    continue;
                }

                int result = dfs(nr, nc, step + 1);
                dp[row][col][step] += result >= 0 ? result : 0;
            }
        }

        // 끝까지 도달 못하는 지점 마크
        if(dp[row][col][step] == 0) {
            dp[row][col][step] = -1;
        }

        return dp[row][col][step];
    }

    static boolean outOfBound(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= M;
    }
}
