import java.io.*;
import java.util.*;

class Main {
    static int N, P, K;
    static List<Cable>[] adjList;

    static class Cable implements Comparable<Cable> {
        int computer;
        long price;
        int freeCnt;

        public Cable(int computer, long price, int freeCnt) {
            this.computer = computer;
            this.price = price;
            this.freeCnt = freeCnt;
        }

        @Override
        public int compareTo(Cable o) {
            if(price == o.price) {
                return freeCnt - o.freeCnt;
            }
            return Long.compare(price, o.price);
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
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adjList = new List[N + 1];

        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long price = Long.parseLong(st.nextToken());

            adjList[from].add(new Cable(to,price, 0));
            adjList[to].add(new Cable(from, price, 0));
        }
    }

    static void solve() {
        PriorityQueue<Cable> pq = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N + 1][K + 1];
        long[][] dist = new long[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        
        pq.add(new Cable(1, 0, 0));
        dist[1][0] = 0;

        while(!pq.isEmpty()) {
            Cable cur = pq.poll();

            if(isVisited[cur.computer][cur.freeCnt]) {
                continue;
            }

            isVisited[cur.computer][cur.freeCnt] = true;

            for(Cable next : adjList[cur.computer]) {
                // 케이블 가격을 내는 경우
                if(!isVisited[next.computer][cur.freeCnt] && dist[next.computer][cur.freeCnt] > Math.max(cur.price, next.price)) {
                    dist[next.computer][cur.freeCnt] = Math.max(cur.price, next.price);
                    pq.add(new Cable(next.computer, dist[next.computer][cur.freeCnt], cur.freeCnt));
                }
                
                // 케이블 공짜인 경우(K개 까지)
                if(cur.freeCnt + 1 <= K && !isVisited[next.computer][cur.freeCnt + 1] && dist[next.computer][cur.freeCnt + 1] > cur.price) {
                    dist[next.computer][cur.freeCnt + 1] = cur.price;
                    pq.add(new Cable(next.computer, cur.price, cur.freeCnt + 1));
                }
            }
        }

        long ans = Long.MAX_VALUE;
        
        for(int i = 0; i <= K; i++) {
            ans = Math.min(ans, dist[N][i]);
        }

        System.out.print(ans == Long.MAX_VALUE ? -1 : ans);
    }
}
