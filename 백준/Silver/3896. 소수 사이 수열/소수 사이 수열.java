import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MAX = 1_299_709 + 1;
    static final int MAX_IDX = 100_000 + 1;

    static boolean[] isNotPrime;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        init();

        for(int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            ans.append(solve(K)).append("\n");
        }

        System.out.print(ans);
    }

    static void init() throws IOException {
        isNotPrime = new boolean[MAX];
        arr = new int[MAX_IDX + 1];

        isNotPrime[1] = true;

        for(int i = 2; i * i < MAX; i++) {
            for(int j = i + i; j < MAX; j += i) {
                isNotPrime[j] = true;
            }
        }

        int index = 0;
        for(int i = 2; i < MAX; i++) {
            if(!isNotPrime[i]) {
                arr[index++] = i;
            }
        }
    }

    static int solve(int K) {
        // K가 소수이면 길이 0
        if(!isNotPrime[K]) {
            return 0;
        }
        
        int index = Arrays.binarySearch(arr, K);

        if(index < 0) {
            index = -1 * (index + 1);
        }

        int left = index - 1 >= 0 ? index - 1 : index;

        return arr[index] - arr[left];
    }
}
