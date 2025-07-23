import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 1_000_000;

    static List<Integer> oddPrimes;
    static Set<Integer> set;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        init();

        while(true) {
            int N = Integer.parseInt(br.readLine());
            boolean isFalse = true;

            if(N == 0) {
                break;
            }

            for(int oddPrime : oddPrimes) {
                if(set.contains(N - oddPrime)) {
                    ans.append(N).append(" = ").append(oddPrime).append(" + ").append(N - oddPrime).append("\n");
                    isFalse = false;
                    break;
                }
            }

            if(isFalse) {
                ans.append("Goldbach's conjecture is wrong.\n");
            }
        }

        System.out.print(ans);
    }

    static void init() {
        boolean[] isNotPrime = new boolean[MAX + 1];
        oddPrimes = new ArrayList<>();
        set = new HashSet<>();

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i = 2; i*i <= MAX; i++) {
            for(int j = i*2; j <= MAX; j+=i) {
                isNotPrime[j] = true;
            }
        }

        for(int i = 3; i <= MAX; i+=2) {
            if(!isNotPrime[i]) {
                oddPrimes.add(i);
                set.add(i);
            }
        }
    }
}
