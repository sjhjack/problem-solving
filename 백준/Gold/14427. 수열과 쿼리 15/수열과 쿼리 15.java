import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] arr;
    static PriorityQueue<Number> pq;

    static class Number implements Comparable<Number> {
        int index;
        int number;

        public Number(int index, int number) {
            this.index = index;
            this.number = number;
        }

        @Override
        public int compareTo(Number o) {
            if(number == o.number) {
                return index - o.index;
            }
            return number - o.number;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pq.add(new Number(i, arr[i]));
        }
    }

    static void solve() throws IOException {
        StringBuilder ans = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if(command == 1) {
                int index = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());

                arr[index] = number;
                pq.add(new Number(index, number));
            } else {
                while(!pq.isEmpty() && pq.peek().number != arr[pq.peek().index]) {
                    pq.poll();
                }

                ans.append(pq.peek().index).append("\n");
            }
        }

        System.out.print(ans);
    }
}
