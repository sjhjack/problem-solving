import java.io.*;
import java.util.*;

class Main {
    static int N, D, K, C;
    static int[] arr, dish;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[2*N];
        dish = new int[D + 1];

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[i] = number;
            arr[N + i] = number;
        }
    }

    static void solve() {
        int count = 1;    // 공짜 초밥 미리 포함
        int ans = 0;

        dish[C]++;    // 공짜 초밥 미리 포함

        // 처음 K개
        for(int i = 0; i < K; i++) {
            if(dish[arr[i]]++ == 0) {
                count++;
            }
        }

        ans = count;

        // 슬라이딩 윈도우
        for(int i = 1; i < N; i++) {
            if(--dish[arr[i - 1]] == 0) {
                count--;
            }
            
            if(dish[arr[i + K - 1]]++ == 0) {
                count++;
            }

            ans = Math.max(ans, count);
        }

        System.out.print(ans);
    }
}
