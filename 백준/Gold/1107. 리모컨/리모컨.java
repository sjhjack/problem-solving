import java.io.*;
import java.util.*;

class Main {
    static boolean[] broken;
    static int target, N;
    static boolean canMinus, canPlus;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        broken = new boolean[10];
        target = Integer.parseInt(br.readLine());
        canMinus = true;
        canPlus = true;

        N = Integer.parseInt(br.readLine());

        if(N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            for(int i = 0; i < N; i++) {
                char c = st.nextToken().charAt(0);
    
                if(c == '-') {
                    canMinus = false;
                } else if(c == '+') {
                    canPlus = false;
                } else {
                    broken[c - '0'] = true;                
                }
            }
        }        
    }

    static void solve() {
        boolean isBroken = false;
        int ans = Integer.MAX_VALUE;

        if(target == 100) {
            System.out.print(0);
            return;
        }

        if(canPlus && target < 100) {
            ans = Math.min(ans, 100 - target);
        }
        if(canMinus && target > 100) {
            ans = Math.min(ans, target - 100);
        }

        for(int i = 0; i <= 999_999; i++) {
            if(i < target && !canPlus) {
                continue;
            }
            if(i > target && !canMinus) {
                continue;
            }

            String number = String.valueOf(i);
            isBroken = false;

            for(int j = 0; j < number.length(); j++) {
                if(broken[number.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }

            if(!isBroken) {
                ans = Math.min(ans, Math.abs(target - i) + number.length());
            }
        }

        System.out.print(ans);
    }
}
