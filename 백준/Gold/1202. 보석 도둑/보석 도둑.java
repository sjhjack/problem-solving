import java.io.*;
import java.util.*;

class Main {

    static int N, K;
    static Jewel[] jewels;
    static long[] bags;

    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return weight - o.weight;
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

        jewels = new Jewel[N];
        bags = new long[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(weight, value);
        }

        for(int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        Arrays.sort(jewels);
    }

    static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        int jewelIdx = 0;

        for(int i = 0; i < K; i++) {
            while(jewelIdx < N && jewels[jewelIdx].weight <= bags[i]) {
                pq.add(jewels[jewelIdx++].value);
            }

            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.print(ans);
    }
}
