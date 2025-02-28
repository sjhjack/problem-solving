import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Map<Long, Integer> map;

    static class Number implements Comparable<Number> {
        long number;
        int count;

        public Number(long number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Number o) {
            if(count == o.count) {
                return Long.compare(number, o.number);
            }
            return o.count - count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            long number = Long.parseLong(br.readLine());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
    }

    static void solve() {
        PriorityQueue<Number> pq = new PriorityQueue<>();

        for(Map.Entry<Long, Integer> entry : map.entrySet()) {
            pq.add(new Number(entry.getKey(), entry.getValue()));
        }

        System.out.print(pq.poll().number);
    }
}
