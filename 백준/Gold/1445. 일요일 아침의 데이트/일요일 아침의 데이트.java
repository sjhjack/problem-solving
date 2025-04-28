import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};

    static int N, M;
    static char[][] arr;
    static boolean[][] nearG;
    static Pos start, end;

    static class Pos implements Comparable<Pos> {
        int row;
        int col;
        int gCnt;
        int nearCnt;

        public Pos(int row, int col, int gCnt, int nearCnt) {
            this.row = row;
            this.col = col;
            this.gCnt = gCnt;
            this.nearCnt = nearCnt;
        }

        @Override
        public int compareTo(Pos o) {
            if(gCnt == o.gCnt) {
                return nearCnt - o.nearCnt;
            }
            return gCnt - o.gCnt;
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
        arr = new char[N][M];
        nearG = new boolean[N][M];
        
        Queue<Pos> gQueue = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'S') {
                    start = new Pos(i, j, 0, 0);
                } else if(arr[i][j] == 'F') {
                    end = new Pos(i, j, 0, 0);
                } else if(arr[i][j] == 'g') {
                    gQueue.add(new Pos(i, j, 0, 0));
                }
            }
        }

        while(!gQueue.isEmpty()) {
            Pos cur = gQueue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(outOfBound(nr, nc) || arr[nr][nc] != '.') {
                    continue;
                }

                nearG[nr][nc] = true;
            }
        }
    }

    static void solve() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][M];

        pq.add(new Pos(start.row, start.col, 0, 0));

        while(!pq.isEmpty()) {
            Pos cur = pq.poll();

            if(isVisited[cur.row][cur.col]) {
                continue;
            }

            if(isEnd(cur)) {
                System.out.print(cur.gCnt + " " + cur.nearCnt);
                return;
            }

            isVisited[cur.row][cur.col] = true;

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(outOfBound(nr, nc) || isVisited[nr][nc]) {
                    continue;
                }

                if(arr[nr][nc] == 'g') {
                    pq.add(new Pos(nr, nc, cur.gCnt + 1, cur.nearCnt));
                } else if(nearG[nr][nc]) {
                    pq.add(new Pos(nr, nc, cur.gCnt, cur.nearCnt + 1));
                } else {
                    pq.add(new Pos(nr, nc, cur.gCnt, cur.nearCnt));
                }
            }
        }
    }

    static boolean outOfBound(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= M;
    }

    static boolean isEnd(Pos pos) {
        return pos.row == end.row && pos.col == end.col;
    }
}
