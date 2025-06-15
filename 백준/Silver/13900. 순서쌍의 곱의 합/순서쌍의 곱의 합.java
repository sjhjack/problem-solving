import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static long[] prefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        prefSum = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefSum[i] = prefSum[i - 1] + arr[i];
        }
    }

    static void solve() {
        long sum = 0;

        for(int i = 1; i <= N; i++) {
            sum += arr[i] * (prefSum[N] - prefSum[i]);
        }

        System.out.print(sum);
    }
}
