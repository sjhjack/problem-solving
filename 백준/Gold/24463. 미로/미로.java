import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    
    static int N, M;
    static char[][] arr;
    static Pos start, end;
    static int[][] dist;
    static Pos[][] history;

    static class Pos {
        int row;
        int col;
        int count;

        public Pos(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

        public boolean isStart(Pos o) {
            return row == o.row && col == o.col;
        }

        public boolean isEnd(int row, int col) {
            return this.row == row && this.col == col;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        dist = new int[N][M];
        history = new Pos[N][M];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                if((i == 0 || i == N-1 || j == 0 || j == M-1) && arr[i][j] == '.') {
                    if(start == null) {
                        start = new Pos(i, j, 0);
                    } else {
                        end = new Pos(i, j, 0);
                    }
                }
            }
        }
    }

    static void solve() {
        findShortestPath();
        markShortestPath();
    }

    static void findShortestPath() {
        Queue<Pos> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        queue.add(start);
        dist[start.row][start.col] = 0;

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] == '+' || dist[nr][nc] <= cur.count + 1) {
                    continue;
                }

                dist[nr][nc] = cur.count + 1;
                history[nr][nc] = cur;

                if(end.isEnd(nr, nc)) {
                    break;
                }
                
                queue.add(new Pos(nr, nc, cur.count + 1));
            }
        }
    }

    static void markShortestPath() {
        Pos tmp = end;
        while(!start.isStart(tmp)) {
            dist[tmp.row][tmp.col] = 0;
            tmp = history[tmp.row][tmp.col];
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == '.') {
                    if(dist[i][j] == 0) {
                        ans.append(".");
                    } else {
                        ans.append("@");
                    }
                } else {
                    ans.append(arr[i][j]);
                }
            }
            
            ans.append("\n");
        }

        System.out.print(ans);
    }
}
