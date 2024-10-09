import java.io.*;
import java.util.*;

class Main {

    static class Number implements Comparable<Number> {
        int num;
        String name;

        public Number(int num, String name) {
            this.num = num;
            this.name = name;
        }

        @Override
        public int compareTo(Number o) {
            return name.compareTo(o.name);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        PriorityQueue<Number> pq = new PriorityQueue<>();
        for(int i = M; i <= N; i++) {
            StringBuilder num = new StringBuilder();
            int tmp = i;
            
            if(tmp / 10 > 0) {
                num.append(map.get(tmp / 10)).append(" ");
            }

            num.append(map.get(tmp % 10));
            pq.add(new Number(i, num.toString()));
        }

        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        
        while(!pq.isEmpty()) {
            ans.append(pq.poll().num).append(" ");
            cnt++;

            if(cnt % 10 == 0) {
                ans.append("\n");
            }
        }

        System.out.print(ans);
    }
}
