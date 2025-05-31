import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int ans = 0;
        
        int[] arr = new int[]{500, 100, 50, 10, 5, 1};
        
        for(int i = 0; i < 6 && N > 0; i++) {
            ans += N / arr[i];
            N %= arr[i];
        }

        System.out.print(ans);
    }
}