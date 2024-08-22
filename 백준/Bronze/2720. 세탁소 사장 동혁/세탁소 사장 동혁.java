import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int[] coin = {25, 10, 5, 1};
        StringBuilder ans = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        

        for(int t = 0; t < T; t++) {
            int change = Integer.parseInt(br.readLine());

            for(int i = 0; i < 4; i++) {
                int x = change / coin[i];
                ans.append(x).append(" ");
                change = x > 0 ? change % (coin[i] * x) : change;
            }
            ans.append("\n");
        }

        System.out.print(ans);
    }
}