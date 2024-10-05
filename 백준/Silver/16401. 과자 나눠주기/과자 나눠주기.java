import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int sum;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
    }

    static void solve() {
        Arrays.sort(arr);
        
        int left = 1;
        int right = arr[N - 1];
        int ans = 0;
        
        while(left <= right) {
            int length = (left + right) / 2;

            if(canShare(length)) {
                ans = length;
                left = length + 1;
            } else {
                right = length - 1;
            }
        }

        System.out.print(ans);
    }

    static boolean canShare(int length) {
        int cnt = 0;
        
        for(int i = 0; i < N; i++) {
            cnt += arr[i] / length;

            if(cnt >= M) {
                break;
            }
        }

        if(cnt >= M) {
            return true;
        } else {
            return false;
        }
    }
}
