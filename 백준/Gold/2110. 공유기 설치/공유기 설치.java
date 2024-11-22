import java.io.*;
import java.util.*;

class Main {
    static int N, C;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
    }

    static void solve() {
        int left = 1;
        int right = arr[N - 1] - arr[0];

        while(left <= right) {
            int mid = (left + right) / 2;

            if(installWifi(mid) < C) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(left - 1);
    }

    static int installWifi(int distance) {
        int count = 1;
        int idx = 0;

        for(int i = 1; i < N; i++) {
            if(arr[i] - arr[idx] >= distance) {
                count++;
                idx = i;
            }
        }

        return count;
    }
}
