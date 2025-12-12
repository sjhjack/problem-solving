import java.io.*;
import java.util.*;

class Main {
    static int N, D;
    static Map<Integer, List<ShortCut>> shortcutMap;
    static int[] dp;

    static class ShortCut {
        int from;
        int dist;

        public ShortCut(int from, int dist) {
            this.from = from;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        shortcutMap = new HashMap<>();
        dp = new int[D + 1];

        Arrays.fill(dp, D * 2);

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(!shortcutMap.containsKey(to)) {
                shortcutMap.put(to, new ArrayList<>());
            }

            shortcutMap.get(to).add(new ShortCut(from, dist));
        }
    }

    static void solve() {
        dp[0] = 0;

        for(int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            if(shortcutMap.containsKey(i)) {
                for(ShortCut shortcut : shortcutMap.get(i)) {
                    dp[i] = Math.min(dp[i], dp[shortcut.from] + shortcut.dist);
                }
            }
        }

        System.out.print(dp[D]);
    }
}
