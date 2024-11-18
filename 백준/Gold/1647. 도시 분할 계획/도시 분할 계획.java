import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<Edge>[] adjList;

    static class Edge implements Comparable<Edge> {
        int number;
        int cost;

        public Edge(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        prim();
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

    static void prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int maxCost = 0;
        int count = 0;
        int sum = 0;

        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(isVisited[cur.number]) {
                continue;
            }
            
            isVisited[cur.number] = true;
            count++;
            sum += cur.cost;
            maxCost = Math.max(maxCost, cur.cost);

            if(count == N) {
                break;
            }

            for(Edge next : adjList[cur.number]) {
                if(!isVisited[next.number]) {
                    pq.add(next);
                }
            }
        }

        System.out.print(sum - maxCost);
    }
}
