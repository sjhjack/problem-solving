import java.io.*;
import java.util.*;

class Main {
    static final int MAX_LENGTH = 20;

    static int N, K;
    static String[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new String[N];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
    }

    static void solve() {
        Queue<String> queue = new ArrayDeque<>();
        int[] count = new int[MAX_LENGTH + 1];
        int index = 0;
        long ans = 0;

        while(index < K) {
            queue.add(arr[index]);
            count[arr[index].length()]++;
            index++;
        }

        while(!queue.isEmpty()) {
            if(index < N) {
                queue.add(arr[index]);
                count[arr[index].length()]++;
                index++;
            }
            
            String cur = queue.poll();
            int length = cur.length();
            
            count[length]--;
            ans += count[length];
        }

        System.out.print(ans);
    }
}
