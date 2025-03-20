import java.io.*;
import java.util.*;

class Main {
    static int N, D;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });
    }

    static void solve() {
        int left = 0;
        int right = 0;
        int gap = 0;
        long sum = 0;
        long ans = 0;

        while(right < N) {
            gap = arr[right][0] - arr[left][0];

            if(gap < D) {
                sum += arr[right][1];
                ans = Math.max(ans, sum);
                right++;
            } else {
                sum -= arr[left][1];
                left++;
            }
        }

        System.out.print(ans);
    }
}
