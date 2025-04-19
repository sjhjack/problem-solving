import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static char[] arr;
    static List<School>[] adjList;

    static class School implements Comparable<School> {
        int number;
        int distance;

        public School(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(School o) {
            return distance - o.distance;
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
        arr = new char[N + 1];
        adjList = new List[N + 1];

        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adjList[u].add(new School(v, d));
            adjList[v].add(new School(u, d));
        }
    }

    static void solve() {
        PriorityQueue<School> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int count = 0;
        int ans = 0;

        pq.add(new School(1, 0));

        while(!pq.isEmpty()) {
            School cur = pq.poll();

            if(isVisited[cur.number]) {
                continue;
            }
            
            isVisited[cur.number] = true;
            ans += cur.distance;
            count++;

            for(School next : adjList[cur.number]) {
                if(!isVisited[next.number] && arr[cur.number] != arr[next.number]) {
                    pq.add(next);
                }
            }
        }

        System.out.print(count == N ? ans : -1);
    }
}
