import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] count = new int[10001];
        boolean[] isAppeared = new boolean[10001];
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            count[number]++;
            isAppeared[number] = true;
        }

        int maxCount = 0;
        int ans = 0;
        
        for(int i = 1; i <= 10000; i++) {
            if(isAppeared[i] && maxCount < count[i]) {
                ans = i;
                maxCount = count[i];
            }
        }

        System.out.print(ans);
    }
}