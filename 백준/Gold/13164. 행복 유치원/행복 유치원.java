import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] arr;
    static List<Integer> priceList;
    
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
        priceList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N - 1; i++) {
            priceList.add(arr[i + 1] - arr[i]);
        }
    }

    static void solve() {
        int ans = 0;

        Collections.sort(priceList);

        for(int i = 0; i < N - K; i++) {
            ans += priceList.get(i);
        }

        System.out.print(ans);
    }
}
