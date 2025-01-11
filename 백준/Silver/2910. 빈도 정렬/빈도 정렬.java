import java.io.*;
import java.util.*;

class Main {
    
    static class Number implements Comparable<Number> {
        int number;
        int count;
        int first;

        public Number(int number, int index) {
            this.number = number;
            this.count = 1;
            this.first = index;
        }

        @Override
        public int compareTo(Number o) {
            if(count == o.count) {
                return first - o.first;
            }

            return o.count - count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        Map<Integer, Number> map = new HashMap<>();   

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            if(map.containsKey(number)) {
                map.get(number).count++;
            } else {
                map.put(number, new Number(number, i));
            }
        }

        PriorityQueue<Number> pq = new PriorityQueue<>(map.values());

        while(!pq.isEmpty()) {
            Number cur = pq.poll();

            for(int i = 0; i < cur.count; i++) {
                ans.append(cur.number).append(" ");
            }
        }
        
        System.out.print(ans);
    }
}
