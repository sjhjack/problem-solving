import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static int sum;
    static boolean[] isVisited;
    
    public static void main(String[] args) throws IOException {
        init();
        solve(0, 0);
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        isVisited = new boolean[sum + 1];
    }

    static void solve(int idx, int weight) {
        if(idx == N) {
            if(weight > 0) {
                isVisited[weight] = true;
            }

            return;
        }

        solve(idx + 1, weight);
        solve(idx + 1, weight + arr[idx]);
        solve(idx + 1, weight - arr[idx]);
    }

    static void print() {
        int ans = 0;
        
        for(int i = 1; i <= sum; i++) {
            if(!isVisited[i]) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}
