import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int start, end;
    static List<Bus>[] busCost;
    
    static class Bus implements Comparable<Bus> {
        int city;
        int cost;

        public Bus(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus b) {
            return cost - b.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        busCost = new List[N + 1];
        for(int i = 1; i <= N; i++) {
            busCost[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            busCost[from].add(new Bus(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        int[] history = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        
        pq.add(new Bus(start, 0));
        history[start] = start;
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Bus cur = pq.poll();

            if(cur.city == end) {
                break;
            }
            
            if(isVisited[cur.city]) {
                continue;
            }
            isVisited[cur.city] = true;

            for(Bus next : busCost[cur.city]) {
                if(!isVisited[next.city] && dist[next.city] > cur.cost + next.cost) {
                    dist[next.city] = cur.cost + next.cost;
                    history[next.city] = cur.city;
                    pq.add(new Bus(next.city, dist[next.city]));
                }
            }
        }


        Stack<Integer> stack = new Stack<>();
        int now = end;
        
        while(history[now] != now) {
            stack.add(now);
            now = history[now];
        }
        stack.add(start);

        StringBuilder ans = new StringBuilder();
        ans.append(dist[end]).append("\n");
        ans.append(stack.size()).append("\n");

        while(!stack.isEmpty()) {
            ans.append(stack.pop()).append(" ");
        }

        System.out.print(ans);
    }
}
