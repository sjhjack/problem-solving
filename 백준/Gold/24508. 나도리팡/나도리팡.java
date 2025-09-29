import java.io.*;
import java.util.*;

class Main {
    static int N, K, T;
    static int[] arr;
    static int zeroCnt;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if(arr[i] == 0) {
                zeroCnt++;
            }
        }

        Arrays.sort(arr);
    }

    static void solve() {
        int left = 0;
        int right = N - 1;

        if(zeroCnt == N) {
            System.out.print("YES");
            return;
        }

        while(left < right && T > 0) {
            int gap = K - arr[right];

            if(arr[left] < gap) {
                T -= arr[left];
                arr[right] += arr[left];
                arr[left++] = 0;
            } else if(arr[left] == gap) {
                T -= arr[left];
                arr[right--] = 0;
                arr[left++] = 0;
            } else {
                T -= gap;
                arr[right--] = 0;
                arr[left] -= gap;
            }
        }

        if(right < left && T >= 0) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
