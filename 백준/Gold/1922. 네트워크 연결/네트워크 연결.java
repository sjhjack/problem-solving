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
            return this.cost - o.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        prim();
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

            adjList[from].add(new Edge(to, cost));
            adjList[to].add(new Edge(from, cost));
        }
    }

    static void prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int ans = 0;

        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(isVisited[cur.num]) {
                continue;
            }
            isVisited[cur.num] = true;
            ans += cur.cost;

            for(Edge next : adjList[cur.num]) {
                if(!isVisited[next.num]) {
                    pq.add(next);
                }
            }
        }

        System.out.print(ans);
    }
}
