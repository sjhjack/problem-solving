import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 100_000_000;
    static int C, N;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // cost
            arr[i][1] = Integer.parseInt(st.nextToken());   // count
        }
    }

    static void solve() {
        int[] dp = new int[C + 101];   // 인덱스 : 인원수, 값 : 비용
        
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            int cost = arr[i][0];
            int count = arr[i][1];
            
            for(int j = count; j < C + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j-count] + cost);
            }
        }

        int ans = MAX;
        for(int i = C; i < C + 101; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.print(ans);
    }
}
