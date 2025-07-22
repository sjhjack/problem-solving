import java.io.*;
import java.util.*;

class Main {
    static int P, N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int ans = 0;

        Arrays.sort(arr);

        for(int i = 0; i < N && P < 200; i++) {
            P += arr[i];
            ans++;
        }

        System.out.print(ans);
    }
}
