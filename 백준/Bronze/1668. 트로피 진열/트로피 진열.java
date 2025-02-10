import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        int left = 0;
        int leftCnt = 0;
        int right = 0;
        int rightCnt = 0;

        for(int i = 0; i < N; i++) {
            if(arr[i] > left) {
                left = arr[i];
                leftCnt++;
            }
        }

        for(int i = N - 1; i >= 0; i--) {
            if(arr[i] > right) {
                right = arr[i];
                rightCnt++;
            }
        }

        System.out.print(leftCnt + "\n" + rightCnt);
    }
}