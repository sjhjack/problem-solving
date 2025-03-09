import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 104729;
    
    static int N;
    static boolean[] isNotPrime;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();        
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isNotPrime = new boolean[MAX + 1];

        isNotPrime[1] = true;
        
        for(int i = 2; i * i <= MAX; i++) {
            for(int j = i + i; j <= MAX; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

    static void solve() {
        int count = 0;
        
        for(int i = 1; i <= MAX; i++) {
            if(!isNotPrime[i]) {
                count++;
                
                if(count == N) {
                    System.out.print(i);
                    break;
                }
            }
        }
    }
}