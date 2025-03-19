import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] count;
    static long[] prefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = new int[1000002];
        prefSum = new long[1000002];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            count[start + 1]++;
            count[end + 1]--;
        }

        int cnt = 0;
        
        for(int i = 1; i < prefSum.length; i++) {
            cnt += count[i];
            prefSum[i] = prefSum[i - 1] + cnt;
        }
    }

    static void solve() {
        int left = 0;
        int right = 1;
        boolean findAns = false;
        
        while(right < prefSum.length) {
            long sum = prefSum[right] - prefSum[left];
            
            if(sum == K) {
                findAns = true;
                break;
            } else if(sum < K) {
                right++;
            } else {
                left++;

                if(left == right) {
                    right++;
                }
            }
        }

        System.out.print(findAns ? left + " " + right : "0 0");
    }
}
