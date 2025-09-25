import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static int[] sumArr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sumArr = new int[N * N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sumArr[i*N + j] = arr[i] + arr[j];
            }
        }

        Arrays.sort(arr);
        Arrays.sort(sumArr);
    }

    static void solve() {
        // target = a + b + c -> target - a = b + c 꼴로 변경해서 생각
        for(int t = N - 1; t >= 0; t--) {
            int target = arr[t];

            for(int i = 0; i <= t; i++) {
                int leftover = target - arr[i];

                if(Arrays.binarySearch(sumArr, leftover) >= 0) {
                    System.out.print(target);
                    return;
                }
            }
        }
    }
}
