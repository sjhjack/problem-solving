import java.io.*;
import java.util.*;

class Main {
    static int M, N;
    static boolean[] isNotPrime;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        
        isNotPrime = new boolean[N + 1];
        isNotPrime[1] = true;
        
        for(int i = 2; i*i <= N; i++) {
            for(int j = i + i; j <= N; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

    static void solve() {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = M; i <= N; i++) {
            if(!isNotPrime[i]) {
                min = Math.min(min, i);
                sum += i;
            }
        }

        if(sum == 0) {
            System.out.print(-1);
        } else {
            System.out.print(sum + "\n" + min);
        }
    }
}