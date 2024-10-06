import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isNotPrime = new boolean[1001];

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i = 2; i*i <= 1000; i++) {
            for(int j = i + i; j <= 1000; j += i) {
                isNotPrime[j] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int num : arr) {
            if(!isNotPrime[num]) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}