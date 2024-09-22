import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];
        int ans = 0;
        
        for(int i = 1; i <= N; i++) {
            ans = Math.max(ans, dp[i]);
            int idx = i + arr[i][0];
            
            if(idx <= N + 1) {
                dp[idx] = Math.max(dp[idx], ans + arr[i][1]);
            }            
        }

        System.out.print(Math.max(ans, dp[N + 1]));
    }
}