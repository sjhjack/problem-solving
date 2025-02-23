import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int maxNum;
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
            maxNum = Math.max(maxNum, arr[i]);
        }
    }

    static void solve() {
        int[] cnt = new int[maxNum + 1];
        int left = 0;
        int right = 1;
        int ans = 1;

        cnt[arr[0]]++;

        while(right < N) {
            while(right < N && cnt[arr[right]] + 1 <= K) {
                cnt[arr[right]]++;
                right++;
            }

            ans = Math.max(ans, right - left);
            cnt[arr[left]]--;
            left++;
        }

        System.out.print(ans);
    }
}
