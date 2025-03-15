import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static Integer[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if(a % 10 == b % 10) {
                return a - b;
            }
            return a % 10 - b % 10;
        });
    }

    static void solve() {
        int ans = 0;
        int count = 0;

        for(int i = 0; i < N; i++) {
            int curCakeLength = arr[i];

            while(curCakeLength > 10 && count < M) {
                curCakeLength -= 10;
                count++;
                ans++;
            }

            if(curCakeLength == 10) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}
