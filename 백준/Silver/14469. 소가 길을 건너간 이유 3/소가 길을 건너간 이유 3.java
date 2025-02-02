import java.io.*;
import java.util.*;

class Main {
    static int N;
    static PriorityQueue<Cow> pq;
    
    static class Cow implements Comparable<Cow> {
        int start;
        int duration;

        public Cow(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }

        @Override
        public int compareTo(Cow o) {
            return start - o.start;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int duration = Integer.parseInt(st.nextToken());

            pq.add(new Cow(start, duration));
        }
    }

    static void solve() {
        int time = 0;

        while(!pq.isEmpty()) {
            Cow cur = pq.poll();

            time = Math.max(time, cur.start) + cur.duration;
        }

        System.out.print(time);
    }
}
