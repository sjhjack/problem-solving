import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<Bus>[] adjList;
    static int start, end;
    
    static class Bus implements Comparable<Bus> {
        int city;
        int cost;

        public Bus(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return cost - o.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new List[N + 1];

        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[from].add(new Bus(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static void dijkstra() {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] totCost = new int[N + 1];

        Arrays.fill(totCost, Integer.MAX_VALUE);

        pq.add(new Bus(start, 0));
        totCost[start] = 0;

        while(!pq.isEmpty()) {
            Bus cur = pq.poll();

            if(isVisited[cur.city]) {
                continue;
            }
            
            if(cur.city == end) {
                System.out.print(totCost[end]);
                break;
            }

            isVisited[cur.city] = true;

            for(Bus next : adjList[cur.city]) {
                if(!isVisited[next.city] && totCost[next.city] > cur.cost + next.cost) {
                    totCost[next.city] = cur.cost + next.cost;
                    pq.add(new Bus(next.city, totCost[next.city]));
                }
            }
        }
    }
}
