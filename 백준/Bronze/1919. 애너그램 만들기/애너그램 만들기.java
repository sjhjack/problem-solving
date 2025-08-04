import java.io.*;
import java.util.*;

class Main {
    static char[] arrA;
    static int[] alphaB;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        arrA = br.readLine().toCharArray();
        alphaB = new int[26];
        
        char[] arrB = br.readLine().toCharArray();
        
        for(int i = 0; i < arrB.length; i++) {
            alphaB[arrB[i]-'a']++;
        }
    }

    static void solve() {
        int ans = 0;

        for(int i = 0; i < arrA.length; i++) {
            if(--alphaB[arrA[i]-'a'] < 0) {
                ans++;
            }
        }

        for(int i = 0; i < alphaB.length; i++) {
            if(alphaB[i] > 0) {
                ans += alphaB[i];
            }
        }

        System.out.print(ans);
    }
}
