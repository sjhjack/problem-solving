import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};

    static int N, M;
    static int[][] arr;

    static class Pos implements Comparable<Pos> {
        int row;
        int col;
        int count;

        public Pos(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

        public boolean isEnd() {
            return row == N - 1 && col == M - 1;
        }

        @Override
        public int compareTo(Pos o) {
            return count - o.count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                arr[i][j] = tmp[j] - '0';
            }
        }
    }

    static void solve() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][M];

        pq.add(new Pos(0, 0, 0));
        isVisited[0][0] = true;

        while(!pq.isEmpty()) {
            Pos cur = pq.poll();

            if(cur.isEnd()) {
                System.out.print(cur.count);
                return;
            }

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc]) {
                    continue;
                }

                pq.add(new Pos(nr, nc, cur.count + arr[nr][nc]));
                isVisited[nr][nc] = true;
            }
        }
    }
}
