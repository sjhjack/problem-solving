import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};

    static int N, M, K;
    static boolean[][] arr;

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
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
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            arr[row][col] = true;
        }
    }

    static void solve() {
        boolean[][] isVisited = new boolean[N][M];
        int ans = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] && !isVisited[i][j]) {
                    Queue<Pos> queue = new ArrayDeque<>();
                    int count = 0;

                    queue.add(new Pos(i, j));
                    isVisited[i][j] = true;
                    count++;

                    while(!queue.isEmpty()) {
                        Pos cur = queue.poll();

                        for(int d = 0; d < 4; d++) {
                            int nr = cur.row + dr[d];
                            int nc = cur.col + dc[d];

                            if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || !arr[nr][nc]) {
                                continue;
                            }

                            queue.add(new Pos(nr, nc));
                            isVisited[nr][nc] = true;
                            count++;
                        }
                    }

                    ans = Math.max(ans, count);
                }
            }
        }

        System.out.print(ans);
    }
}
