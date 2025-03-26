import java.io.*;
import java.util.*;

class Main {
    static int N, M;
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
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
    }

    static void solve() {
        int left = 0;
        int right = 1;
        int ans = Integer.MAX_VALUE;

        while(right < N) {
            int gap = arr[right] - arr[left];

            if(gap >= M) {
                ans = Math.min(ans, gap);

                if(left < right) {
                    left++;
                } else {
                    right++;
                }
            } else {
                right++;
            }
        }

        System.out.print(ans);
    }
}
