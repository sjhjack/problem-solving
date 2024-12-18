import java.io.*;
import java.util.*;

class Main {
    static int A, K;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dp = new int[1_000_001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        queue.add(A);
        dp[A] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == K) {
                System.out.print(dp[K]);
                break;
            }

            if(cur + 1 <= K && dp[cur + 1] > dp[cur] + 1) {
                queue.add(cur + 1);
                dp[cur + 1] = dp[cur] + 1;
            }

            if(cur * 2 <= K && dp[cur * 2] > dp[cur] + 1) {
                queue.add(cur * 2);
                dp[cur * 2] = dp[cur] + 1;
            }
        }
    }
}
