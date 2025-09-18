import java.io.*;
import java.util.*;

class Main {
    static int S, C;
    static int[] arr;
    static int maxLength;
    static long total;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[S];
        maxLength = 0;

        for(int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, arr[i]);
            total += arr[i];
        }
    }

    static void solve() {
        long min = 1;
        long max = maxLength;
        long leftover = 0;

        while(min <= max) {
            long mid = (min + max) / 2;
            int count = 0;

            for(int i = 0; i < S; i++) {
                count += arr[i] / mid;
            }

            if(count >= C) {
                min = mid + 1;
                leftover = total - mid * C;
            } else {
                max = mid - 1;
            }
        }

        System.out.print(leftover);
    }
}
