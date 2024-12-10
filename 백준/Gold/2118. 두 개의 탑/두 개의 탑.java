import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static int sum;
    
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
            sum += arr[i];
        }
    }

    static void solve() {
        int start = 0;
        int end = 0;
        int clockWise = arr[end];
        int counterClockWise = sum - arr[end];
        int maxDist = 0;
        
        while(start < N) {
            if(clockWise < counterClockWise) {
                maxDist = Math.max(maxDist, clockWise);
                
                end = (end + 1) % N;
                clockWise += arr[end];
                counterClockWise -= arr[end];
            } else {
                maxDist = Math.max(maxDist, counterClockWise);
                
                clockWise -= arr[start];
                counterClockWise += arr[start];
                start++;
            }
        }

        System.out.print(maxDist);
    }
}
