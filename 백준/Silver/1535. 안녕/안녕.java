import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        StringTokenizer life = new StringTokenizer(br.readLine());
        StringTokenizer joy = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(life.nextToken());
            arr[i][1] = Integer.parseInt(joy.nextToken());
        }
    }

    static void solve() {
        int[] dp = new int[100];   // 체력이 0이되면 안 되니까 99까지만 탐색
        
        for(int i = 0; i < N; i++) {
            int life = arr[i][0];
            int joy = arr[i][1];
            
            for(int j = 99; j >= life; j--) {
                dp[j] = Math.max(dp[j], dp[j - life] + joy);
            }
        }

        System.out.print(dp[99]);
    }
}
