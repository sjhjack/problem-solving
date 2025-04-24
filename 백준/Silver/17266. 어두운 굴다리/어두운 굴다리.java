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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int start = 1;
        int end = N;
        int ans = N;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(isValid(mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.print(ans);
    }

    static boolean isValid(int height) {
        int last = 0;    // 이전 가로등의 마지막 범위

        for(int i = 0; i < M; i++) {
            int left = arr[i] - height < 0 ? 0 : arr[i] - height;
            int right = arr[i] + height;

            if(last < left) {
                return false;
            } else {
                last = right;
            }
        }

        return last >= N;
    }
}
