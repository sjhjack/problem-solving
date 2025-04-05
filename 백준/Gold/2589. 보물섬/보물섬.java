import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};    // 상하좌우
    static final int[] dc = {0,0,-1,1};
    
    static int N, M;
    static char[][] arr;
    static Queue<Pos> landList;
    static int max;

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
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        landList = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                if(tmp[j] == 'L') {
                    landList.add(new Pos(i, j, 0));
                }
                arr[i][j] = tmp[j];
            }
        }
    }

    static void solve() {
        max = 0;

        while(!landList.isEmpty()) {
            bfs(landList.poll());
        }

        System.out.print(max);
    }

    static void bfs(Pos start) {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];

        queue.add(start);
        isVisited[start.row][start.col] = true;
        
        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || arr[nr][nc] == 'W') {
                    continue;
                }

                isVisited[nr][nc] = true;
                queue.add(new Pos(nr, nc, cur.count + 1));
                max = Math.max(max, cur.count + 1);
            }
        }
    }
}
