import java.io.*;
import java.util.*;

class Main {
    static int L, N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        L = Integer.parseInt(br.readLine());
        arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        N = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
    }

    static void solve() {
        int index = Arrays.binarySearch(arr, N);

        if(index >= 0) {
            System.out.print(0);
            return;
        }

        index = -1 * (index + 1);

        int left = index > 0 ? N - (arr[index - 1] + 1) : N - 1;
        int right = index < L - 1 ? arr[index] - 1 - N : arr[L - 1] - 1 - N;

        System.out.print(left * (right + 1) + right);
    }
}
