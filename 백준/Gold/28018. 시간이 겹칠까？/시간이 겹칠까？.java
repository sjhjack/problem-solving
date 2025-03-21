import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MAX = 1_000_000;

    static int N;
    static int[] prefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        prefSum = new int[MAX + 1];
        int[] count = new int[MAX + 2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            count[start]++;
            count[end + 1]--;
        }

        for(int i = 1; i <= MAX; i++) {
            prefSum[i] = prefSum[i - 1] + count[i];
        }
    }

    static void solve() throws IOException {
        StringBuilder ans = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < Q; i++) {
            int time = Integer.parseInt(st.nextToken());
            ans.append(prefSum[time]).append("\n");
        }

        System.out.print(ans);
    }
}
