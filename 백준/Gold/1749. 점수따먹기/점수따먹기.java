import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] horizonPrefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        horizonPrefSum = new int[N + 1][M + 1];
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                horizonPrefSum[i][j] = horizonPrefSum[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        int ans = Integer.MIN_VALUE;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                
                for(int k = 1; k <= j; k++) {
                    int sum = 0;
                    for(int l = 0; l < i; l++) {
                        sum += horizonPrefSum[i-l][j] - horizonPrefSum[i-l][j-k];
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }

        System.out.print(ans);
    }
}
