import java.io.*;
import java.util.*;

class Main {
    static int N, S;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());
    }

    static void solve() {
        int now = 0;

        while(now < N - 1 && S > 0) {
            int next = now + 1;
            int max = arr[now];
            int maxIdx = now;

            while(next < N && next - now <= S) {
                if(max < arr[next]) {
                    max = arr[next];
                    maxIdx = next;
                }
                
                next++;
            }

            if(maxIdx > now) {
                for(int i = maxIdx; i > now; i--) {
                    swap(i);
                    S--;
                }
            }

            now++;
        }
    }

    static void swap(int idx) {
        int tmp = arr[idx];
        arr[idx] = arr[idx - 1];
        arr[idx - 1] = tmp;
    }

    static void print() {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < N; i++) {
            ans.append(arr[i]).append(" ");
        }

        System.out.print(ans);
    }
}
