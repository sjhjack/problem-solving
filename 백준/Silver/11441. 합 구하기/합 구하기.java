import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] prefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        int N = Integer.parseInt(br.readLine());
        prefSum = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            prefSum[i] = prefSum[i - 1] + Integer.parseInt(st.nextToken());
        }
    }

    static void solve() throws IOException {
        StringBuilder ans = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ans.append(prefSum[end] - prefSum[start - 1]).append("\n");
        }

        System.out.print(ans);
    }
}
