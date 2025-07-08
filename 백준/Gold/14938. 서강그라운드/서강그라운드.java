import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 100_000_000;
    
    static int N, M, R;
    static int[] arr;
    static List<Node>[] adjList;

    static class Node implements Comparable<Node> {
        int number;
        int dist;

        public Node(int number, int dist) {
            this.number = number;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
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
        R = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        adjList = new List[N + 1];

        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, dist));
            adjList[to].add(new Node(from, dist));
        }
    }

    static void solve() {
        int ans = 0;

        for(int i = 1; i <= N; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] dist = new int[N + 1];
            boolean[] isVisited = new boolean[N + 1];
            int sum = 0;

            Arrays.fill(dist, MAX);
            
            pq.add(new Node(i, 0));
            dist[i] = 0;

            while(!pq.isEmpty()) {
                Node cur = pq.poll();

                if(isVisited[cur.number]) {
                    continue;
                }

                isVisited[cur.number] = true;

                for(Node next : adjList[cur.number]) {
                    if(!isVisited[next.number] && dist[next.number] > cur.dist + next.dist) {
                        dist[next.number] = cur.dist + next.dist;
                        pq.add(new Node(next.number, cur.dist + next.dist));
                    }
                }
            }

            for(int j = 1; j <= N; j++) {
                if(dist[j] <= M) {
                    sum += arr[j];
                }
            }

            ans = Math.max(ans, sum);
        }

        System.out.print(ans);
    }
}
