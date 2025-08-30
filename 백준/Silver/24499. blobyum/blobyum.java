import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int max = 0;
        int sum = 0;

        for(int i = 0; i < K; i++) {
            sum += arr[i];
        }

        max = sum;

        for(int i = 0; i < N; i++) {
            sum -= arr[i];
            sum += arr[(i + K) % N];

            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}
