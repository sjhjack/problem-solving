import java.io.*;
import java.util.*;

class Main {
    static int N, X;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i < N; i++) {
            min = Math.min(min, arr[i]*X + arr[i - 1]*X);
        }

        System.out.print(min);
    }
}