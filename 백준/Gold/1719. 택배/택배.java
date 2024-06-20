import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] result;
    private static List<Info>[] adjList;

    private static class Info implements Comparable<Info> {
        int number;
        int cost;

        public Info(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N + 1][N + 1];
        adjList = new List[N + 1];

        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[from].add(new Info(to, cost));
            adjList[to].add(new Info(from, cost));
        }
    }

    private static void solve() {
        for(int i = 1; i <= N; i++) {
            dijkstra(i);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(Info info : adjList[start]) {
            result[start][info.number] = info.number;
            dist[info.number] = info.cost;
            pq.add(new Info(info.number, info.cost));
        }

        while(!pq.isEmpty()) {
            Info cur = pq.poll();

            if(isVisited[cur.number]) continue;
            isVisited[cur.number] = true;

            for(Info next : adjList[cur.number]) {
                if(!isVisited[next.number] && dist[next.number] > cur.cost + next.cost) {
                    dist[next.number] = cur.cost + next.cost;
                    result[start][next.number] = result[start][cur.number];
                    pq.add(new Info(next.number, dist[next.number]));
                }
            }
        }
    }

    private static void print() {
        StringBuilder ans = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    ans.append("- ");
                } else {
                    ans.append(result[i][j]).append(" ");
                }
            }
            ans.append("\n");
        }

        System.out.print(ans);
    }
}
