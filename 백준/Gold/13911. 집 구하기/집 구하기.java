import java.io.*;
import java.util.*;

class Main {
    static int V, E;
    static int M, m, S, s;
    static List<House>[] adjList;
    static int[] macList, starList;
    static int[] macDist, starDist;

    static class House implements Comparable<House> {
        int num;
        int len;

        public House(int num, int len) {
            this.num = num;
            this.len = len;
        }

        @Override
        public int compareTo(House o) {
            return len - o.len;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjList = new List[V + 1];
        macDist = new int[V + 1];
        starDist = new int[V + 1];

        for(int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        Arrays.fill(macDist, Integer.MAX_VALUE);
        Arrays.fill(starDist, Integer.MAX_VALUE);

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            adjList[from].add(new House(to, len));
            adjList[to].add(new House(from, len));
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        macList = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            macList[i] = num;
            macDist[num] = 0;
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        starList = new int[S];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < S; i++) {
            int num = Integer.parseInt(st.nextToken());
            starList[i] = num;
            starDist[num] = 0;
        }
    }

    static void solve() {
        dijkstra(macList, macDist);
        dijkstra(starList, starDist);
        findMinDist();
    }

    static void dijkstra(int[] targetList, int[] targetDist) {
        PriorityQueue<House> pq = new PriorityQueue<>();
        int[] dist = new int[V + 1];
        boolean[] isVisited = new boolean[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int target : targetList) {
            pq.add(new House(target, 0));
            dist[target] = 0;
        }

        while(!pq.isEmpty()) {
            House cur = pq.poll();

            if(isVisited[cur.num]) {
                continue;
            }
            isVisited[cur.num] = true;

            for(House next : adjList[cur.num]) {
                if(!isVisited[next.num] && targetDist[next.num] > 0 && dist[next.num] > cur.len + next.len) {
                    dist[next.num] = cur.len + next.len;
                    targetDist[next.num] = Math.min(targetDist[next.num], dist[next.num]);
                    pq.add(new House(next.num, dist[next.num]));
                }
            }
        }
        
    }

    static void findMinDist() {
        int ans = Integer.MAX_VALUE;

        for(int i = 1; i <= V; i++) {
            if(macDist[i] == 0 || starDist[i] == 0) {
                continue;
            }

            if(macDist[i] <= m && starDist[i] <= s) {
                ans = Math.min(ans, macDist[i] + starDist[i]);
            }
        }

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
