import java.io.*;
import java.util.*;

class Main {
    static int[][][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        dp = new int[21][21][21];

        while(true) {
            String s = br.readLine();
            
            if(s.equals("-1 -1 -1")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ans.append("w("+a+", "+b+", "+c+") = ").append(w(a, b, c)).append("\n");
        }

        System.out.print(ans);
    }

    static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        
        if(a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }        
        
        if(dp[a][b][c] > 0) {
            return dp[a][b][c];
        }

        if(a < b && b < c) {
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return dp[a][b][c] = dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
