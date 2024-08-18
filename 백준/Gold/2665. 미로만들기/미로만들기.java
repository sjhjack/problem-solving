import java.util.*;
import java.io.*;

class Main {
    private static final int[] dr = {-1,1,0,0};    // 상하좌우
    private static final int[] dc = {0,0,-1,1};
    private static int[][] map;
    private static int N;

    private static class Pos {
        int row;
        int col;
        int change;

        public Pos(int row, int col, int change) {
            this.row = row;
            this.col = col;
            this.change = change;
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            
            for(int j = 0; j < N; j++) {
                map[i][j] = tmp[j] - '0';
            }
        }
    }

    private static void solve() {
        Queue<Pos> queue = new ArrayDeque<>();
        int[][] arr = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        queue.add(new Pos(0, 0, 0));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                if(nr == N-1 && nc == N-1) {
                    arr[nr][nc] = Math.min(arr[nr][nc], cur.change);
                    continue;
                }

                if(map[nr][nc] == 1) {
                    if(arr[nr][nc] > cur.change) {
                        arr[nr][nc] = cur.change;
                        queue.add(new Pos(nr, nc, cur.change));
                    }
                } else if(map[nr][nc] == 0) {
                    if(arr[nr][nc] > cur.change + 1) {
                        arr[nr][nc] = cur.change + 1;
                        queue.add(new Pos(nr, nc, cur.change + 1));
                    }
                }
            }
        }

        System.out.print(arr[N-1][N-1]);
    }
}
