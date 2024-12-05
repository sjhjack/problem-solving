import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    
    static int N, M;
    static int[][] arr;

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
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];
        int pictureCount = 0;
        int maxSize = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(isVisited[i][j] || arr[i][j] == 0) {
                    continue;
                }

                pictureCount++;
                
                int size = 1;
                queue.add(new Pos(i, j));
                isVisited[i][j] = true;

                while(!queue.isEmpty()) {
                    Pos cur = queue.poll();

                    for(int d = 0; d < 4; d++) {
                        int nr = cur.row + dr[d];
                        int nc = cur.col + dc[d];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || arr[nr][nc] == 0) {
                            continue;
                        }

                        size++;
                        queue.add(new Pos(nr, nc));
                        isVisited[nr][nc] = true;
                    }
                }

                maxSize = Math.max(maxSize, size);
            }
        }

        System.out.print(pictureCount + "\n" + maxSize);
    }
}
