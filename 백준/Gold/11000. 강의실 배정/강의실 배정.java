import java.io.*;
import java.util.*;

class Main {
    static int N, lastTime;
    static Class[] arr;
    
    static class Class implements Comparable<Class> {
        int start;
        int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class o) {
            if(start == o.start) {
                return end - o.end;
            }
            return start - o.start;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Class[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Class(start, end);
            lastTime = Math.max(lastTime, end);
        }

        Arrays.sort(arr);
    }

    static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;

        for(int i = 0; i < N; i++) {
            while(!pq.isEmpty() && pq.peek() <= arr[i].start) {
                pq.poll();
            }
            
            pq.add(arr[i].end);
            ans = Math.max(ans, pq.size());
        }

        System.out.print(ans);
    }
}
