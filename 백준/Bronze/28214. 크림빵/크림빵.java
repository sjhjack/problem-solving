import java.io.*;
import java.util.*;

class Main {
    static int N, K, P;
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
        P = Integer.parseInt(st.nextToken());
        arr = new int[N * K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N * K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int ans = 0;

        for(int i = 0; i < N; i++) {
            int count = 0;
            
            for(int j = 0; j < K; j++) {
                if(arr[i*K + j] == 0) {
                    count++;
                }
            }

            if(count < P) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}
