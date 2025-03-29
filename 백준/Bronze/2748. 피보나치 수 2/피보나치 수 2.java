import java.io.*;
import java.util.*;

class Main {
    static long[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        System.out.print(fibo(N));
    }

    static long fibo(int N) {
        if(dp[N] < 0) {
            dp[N] = fibo(N - 1) + fibo(N - 2);
        }
        return dp[N];
    }
}