import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static PriorityQueue<Vote> pq1, pq2;

    static class Vote {
        int number;
        int a;
        int b;

        public Vote(int number, int a, int b) {
            this.number = number;
            this.a = a;
            this.b = b;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pq1 = new PriorityQueue<>((o1, o2) -> o2.a - o1.a);
        pq2 = new PriorityQueue<>((o1, o2) -> o2.b - o1.b);

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq1.add(new Vote(i, a, b));
        }
    }

    static void solve() {
        for(int i = 0; i < K; i++) {
            pq2.add(pq1.poll());
        }

        System.out.print(pq2.poll().number);
    }
}
