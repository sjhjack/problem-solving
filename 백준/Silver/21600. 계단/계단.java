import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int ans = 0;
        int height = 0;

        for(int i = 0; i < N; i++) {
            if(height + 1 <= arr[i]) {
                height++;
            } else {
                height = arr[i];
            }

            ans = Math.max(ans, height);
        }

        System.out.print(ans);
    }
}
