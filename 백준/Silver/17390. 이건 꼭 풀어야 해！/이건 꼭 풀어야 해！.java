import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int N, Q;
    static int[] prefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        prefSum = new int[N + 1];

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 1; i <= N; i++) {
            prefSum[i] = prefSum[i - 1] + arr[i - 1];
        }
    }

    static void solve() throws IOException {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            ans.append(prefSum[R] - prefSum[L - 1]).append("\n");
        }

        System.out.print(ans);
    }
}
