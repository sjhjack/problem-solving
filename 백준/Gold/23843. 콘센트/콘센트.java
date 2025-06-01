import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = N - 1;
        int ans = 0;

        for(int i = 0; i < M; i++) {
            pq.add(0);
        }

        Arrays.sort(arr);

        while(!pq.isEmpty()) {
            int endTime = pq.poll();
            ans = Math.max(ans, endTime);

            if(index >= 0) {
                pq.add(endTime + arr[index--]);
            }
        }

        System.out.print(ans);
    }
}
