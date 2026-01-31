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
        arr = new int[N];
        M = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
    }

    static void solve() {
        int sum = 0;
        
        for(int i = 0; i < N; i++) {
            sum += arr[i];
        }

        if(sum <= M) {
            System.out.print(arr[N - 1]);
            return;
        }

        binarySearch();
    }

    static void binarySearch() {
        int min = 1;
        int max = Math.min(M, arr[N - 1]);
        int maxSum = 0;
        int maxMid = 0;

        while(min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;

            for(int i = 0; i < N; i++) {
                sum += Math.min(mid, arr[i]);
            }

            if(sum > M) {
                max = mid - 1;
                continue;
            }

            if(sum >= maxSum) {
                maxSum = sum;
                maxMid = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.print(maxMid);
    }
}
