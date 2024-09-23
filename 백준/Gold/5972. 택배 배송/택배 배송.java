import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<Edge>[] adjList;

    static class Edge implements Comparable<Edge> {
        int num;
        int cost;

        public Edge(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new List[N + 1];
        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to, cost));
            adjList[to].add(new Edge(from, cost));
        }
    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] totCost = new int[N + 1];
        boolean[] isVisited = new boolean[N + 1];

        Arrays.fill(totCost, Integer.MAX_VALUE);
        
        pq.add(new Edge(1, 0));
        totCost[1] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(isVisited[cur.num]) {
                continue;
            }
            isVisited[cur.num] = true;

            for(Edge next : adjList[cur.num]) {
                if(!isVisited[next.num] && totCost[next.num] > cur.cost + next.cost) {
                    totCost[next.num] = cur.cost + next.cost;
                    pq.add(new Edge(next.num, totCost[next.num]));
                }
            }
        }

        System.out.print(totCost[N]);
    }
}
