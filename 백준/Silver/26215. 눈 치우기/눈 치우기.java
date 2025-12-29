import java.io.*;
import java.util.*;

class Main {
    static int N;
    static PriorityQueue<Integer> pq;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();        
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        int ans = 0;
        
        while(pq.size() > 1) {
            int max = pq.poll();
            int min = pq.poll();

            ans += min;
            pq.add(max - min);
        }

        if(!pq.isEmpty()) {
            ans += pq.poll();
        }

        System.out.print(ans <= 1440 ? ans : -1);
    }
}
