import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int ans = P;

        if(N >= 20) {
            ans = Math.min(ans, P * 3 / 4);
        }

        if(N >= 15) {
            ans = Math.min(ans, P - 2000);
        }

        if(N >= 10) {
            ans = Math.min(ans, P * 9 / 10);
        }

        if(N >= 5) {
            ans = Math.min(ans, P - 500);
        }

        System.out.print(ans >= 0 ? ans : 0);
    }
}