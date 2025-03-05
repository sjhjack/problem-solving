import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int left = 0;
        int right = 1;
        int sum = 1;
        int ans = 0;

        while(right <= N) {
            if(sum == N) {
                ans++;
                sum -= left++;
                sum += ++right;
            } else if(sum < N) {
                sum += ++right;
            } else {
                sum -= left++;
            }
        }

        System.out.print(ans);
    }
}
