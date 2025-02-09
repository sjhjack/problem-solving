import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Integer[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        Arrays.sort(arr, Comparator.reverseOrder());

        int ans = 0;

        for(int i = 1; i <= N; i++) {
            ans = Math.max(ans, i + arr[i - 1] + 1);
        }

        System.out.print(ans);
    }
}