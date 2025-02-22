import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] prefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        prefSum = new int [N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            prefSum[i] = prefSum[i - 1] + Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int max = Integer.MIN_VALUE;

        for(int i = K; i <= N; i++) {
            max = Math.max(max, prefSum[i] - prefSum[i - K]);
        }

        System.out.print(max);
    }
}