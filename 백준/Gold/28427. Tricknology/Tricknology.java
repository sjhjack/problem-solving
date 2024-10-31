import java.io.*;
import java.util.*;

class Main {
    static int[] primeSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() {
        boolean[] prime = new boolean[1_000_001];

        prime[1] = true;
        
        for(int i = 2; i*i <= 1_000_000; i++) {
            if(prime[i]) continue;
            
            for(int j = i+i; j <= 1_000_000; j+=i) {
                prime[j] = true;
            }
        }

        int[] markPrime = new int[500_000];
        for(int i = 2; i <= 499_999; i++) {
            if(!prime[i + (i + 1)]) {
                markPrime[i] = 1;
            }
        }

        primeSum = new int[500_000];
        for(int i = 2; i <= 499_999; i++) {
            primeSum[i] = primeSum[i - 1] + markPrime[i];
        }
    }

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            ans.append(primeSum[R-1] - primeSum[L-1]).append("\n");
        }

        System.out.print(ans);
    }
}
