import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static Queue<Thing> queue = new ArrayDeque<>();

    static class Thing {
        int weight;
        int value;

        public Thing(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            int cnt = 1;
            while(cnt <= count){
                queue.add(new Thing(weight * cnt, value * cnt));
                count -= cnt;
                cnt <<= 1;
            }

            if(count > 0){
                queue.add(new Thing(weight * count, value * count));
            }
        }
    }

    static void solve() {
        long[] dp = new long[M + 1];

        while(!queue.isEmpty()){
            Thing cur = queue.poll();

            for(int i = M; i >= cur.weight; i--){
                dp[i] = Math.max(dp[i], dp[i - cur.weight] + (long)cur.value);
            }
        }

        System.out.print(dp[M]);
    }
}
