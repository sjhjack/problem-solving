import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] prefixSum;
    
    public static void main(String[] args) throws IOException {
        input();
        solve();        
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + num;
        }
    }

    static void solve() {
        int start = 0;
        int end = 0;
        int cnt = 0;

        while(start <= end && end <= N) {
            int sum = prefixSum[end] - prefixSum[start];

            if(sum == M) {
                cnt++;
                start++;
                end++;
            } else if(sum < M) {
                end++;
            } else {
                start++;
            }
        }

        System.out.print(cnt);
    }
}