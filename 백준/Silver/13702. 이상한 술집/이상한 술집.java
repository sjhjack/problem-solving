import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static long[] bottle;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();        
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bottle = new long[N];

        for(int i = 0; i < N; i++) {
            bottle[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(bottle);
    }

    static void solve() {
        long start = 1;
        long end = bottle[N - 1];
        long ans = 0;

        while(start <= end) {
            long mid = (start + end) / 2;

            if(mid > 0 && canShare(mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.print(ans);
    }
    
    static boolean canShare(long mid) {
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            cnt += bottle[i] / mid;

            if(cnt >= K) {
                return true;
            }
        }

        return false;
    }
}
