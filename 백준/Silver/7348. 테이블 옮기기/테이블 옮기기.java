import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder ans = new StringBuilder();

    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            init();
            solve();
        }

        System.out.print(ans);
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[201];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = (Integer.parseInt(st.nextToken()) - 1) / 2;
            int t = (Integer.parseInt(st.nextToken()) - 1) / 2;

            arr[Math.min(s, t)]++;
            arr[Math.max(s, t) + 1]--;
        }
    }

    static void solve() {
        int max = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }

        ans.append(max * 10).append("\n");
    }
}
