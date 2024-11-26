import java.io.*;
import java.util.*;

class Main {
    static int N, M, L;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        arr[N + 1] = L;
        
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    static void solve() {
        int left = 1;
        int right = L;
        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;

            for(int i = 0; i < N + 1; i++) {
                cnt += (arr[i + 1] - arr[i] - 1) / mid;
            }

            if(cnt <= M) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }
}
