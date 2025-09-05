import java.io.*;
import java.util.*;

class Main {
    static int N, X;
    static int[] prefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        prefSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            prefSum[i] = prefSum[i - 1] + Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int max = 0;
        int count = 0;

        for(int i = X; i <= N; i++) {
            int curVisitors = prefSum[i] - prefSum[i - X];
            
            if(max < curVisitors) {
                max = curVisitors;
                count = 1;
            } else if(max == curVisitors) {
                count++;
            }
        }

        if(max == 0) {
            System.out.print("SAD");
            
        } else {
            System.out.print(max + "\n" + count);
        }
    }
}
