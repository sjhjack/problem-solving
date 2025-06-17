import java.io.*;
import java.util.*;

class Main {
    static final long MAX = 90_000_000_000L;
    static int N, M;
    static int[] oil;
    static List<Node>[] adjList;

    static class Node implements Comparable<Node> {
        int number;
        int distance;
        long totalCost;
        int minCost;

        public Node(int number, int distance, long totalCost, int minCost) {
            this.number = number;
            this.distance = distance;
            this.totalCost = totalCost;
            this.minCost = minCost;
        }

        public Node(int number, int distance) {
            this(number, distance, 0, 3000);
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(totalCost, o.totalCost);
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        oil = new int[N + 1];
        adjList = new List[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, distance));
            adjList[to].add(new Node(from, distance));
        }
    }

    static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N + 1][2501];    // [주유소][최저 가격]
        long[][] dist = new long[N + 1][2501];               // [주유소][최저 가격]

        for(int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], MAX);            
        }

        dist[1][oil[1]] = 0;
        pq.add(new Node(1, 0, 0, oil[1]));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.number == N) {
                System.out.print(cur.totalCost);
                return;
            }

            if(isVisited[cur.number][cur.minCost]) {
                continue;
            }
            isVisited[cur.number][cur.minCost] = true;

            for(Node next : adjList[cur.number]) {
                int min = Math.min(cur.minCost, oil[cur.number]);
                long cost = cur.totalCost + min * next.distance;

                if(!isVisited[next.number][min] && dist[next.number][min] > cost) {
                    dist[next.number][min] = cost;
                    pq.add(new Node(next.number, 0, cost, min));
                }
            }
        }
    }
}
