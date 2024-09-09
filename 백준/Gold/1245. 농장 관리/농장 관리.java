import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0,-1,-1,1,1};   // 상하좌우 좌상 우상 좌하 우하
    static final int[] dc = {0,0,-1,1,-1,1,-1,1};
    static int N, M;
    static int[][] arr;
    static PriorityQueue<Pos> pq = new PriorityQueue<>();

    static class Pos implements Comparable<Pos> {
        int row;
        int col;
        int height;

        public Pos(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Pos o) {
            return o.height - height;
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
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new Pos(i, j, arr[i][j]));
            }
        }
    }

    static void solve() {
        boolean[][] isVisited = new boolean[N][M];
        Queue<Pos> queue = new ArrayDeque<>();
        int ans = 0;

        while(!pq.isEmpty()) {
            Pos start = pq.poll();
            
            if(isVisited[start.row][start.col]) {
                continue;
            }

            isVisited[start.row][start.col] = true;
            queue.add(new Pos(start.row, start.col, arr[start.row][start.col]));
            
            while(!queue.isEmpty()) {
                Pos cur = queue.poll();

                for(int d = 0; d < 8; d++) {
                    int nr = cur.row + dr[d];
                    int nc = cur.col + dc[d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || arr[nr][nc] > cur.height) {
                        continue;
                    }

                    isVisited[nr][nc] = true;
                    queue.add(new Pos(nr, nc, arr[nr][nc]));
                }
            }
            
            ans++;
        }

        System.out.print(ans);
    }
}
