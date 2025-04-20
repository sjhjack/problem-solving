import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();        
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        int ans = 0;

        for(int i = 1; i <= K; i++) {
            int number = N * i;
            int reverseNumber = 0;

            while(number > 0) {
                reverseNumber = reverseNumber * 10 + number % 10;
                number /= 10;
            }

            ans = Math.max(ans, reverseNumber);
        }

        System.out.print(ans);
    }
}