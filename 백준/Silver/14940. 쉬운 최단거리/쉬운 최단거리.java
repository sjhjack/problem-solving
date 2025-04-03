import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};    // 상하좌우
    static final int[] dc = {0,0,-1,1};
    
    static int N, M;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] isVisited;
    static Queue<Pos> queue;

    static class Pos {
        int row;
        int col;
        int count;

        public Pos(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
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
        
        arr = new int[N][M];
        dist = new int[N][M];
        isVisited = new boolean[N][M];
        queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 2) {
                    queue.add(new Pos(i, j, 0));
                    dist[i][j] = 0;
                    isVisited[i][j] = true;
                }
            }
        }
    }

    static void solve() {
        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(isInvalid(nr, nc)) {
                    continue;
                }

                queue.add(new Pos(nr, nc, cur.count + 1));
                dist[nr][nc] = cur.count + 1;
                isVisited[nr][nc] = true;
            }
        }
    }

    static boolean isInvalid(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= M || isVisited[row][col] || arr[row][col] == 0;
    }

    static void print() {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1 && dist[i][j] == 0) {
                    ans.append("-1 ");
                } else {
                    ans.append(dist[i][j]).append(" ");
                }
            }
            ans.append("\n");
        }

        System.out.print(ans);
    }
}
