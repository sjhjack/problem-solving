import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Pos {
        int row;
        int col;
        int len;
        int wall;
        boolean isDaytime;

        public Pos(int row, int col, int len, int wall, boolean isDaytime) {
            this.row = row;
            this.col = col;
            this.len = len;
            this.wall = wall;
            this.isDaytime = isDaytime;
        }

        boolean isEnd() {
            return row == N-1 && col == M-1;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = tmp[j] - '0';
            }
        }
    }

    static void solve() {
        int[][][] dist = new int[N][M][K+1];
        Queue<Pos> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < K+1; k++){
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        q.add(new Pos(0, 0, 1, 0, true));
        dist[0][0][0] = 1;
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Pos cur = q.poll();

            if(cur.isEnd()){
                min = Math.min(min, cur.len);
                continue;
            }

            for(int d = 0; d < 4; d++){
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(isOutOfBound(nr, nc) || (cur.wall == K && map[nr][nc] == 1)) continue;

                if(map[nr][nc] == 0){
                    if(dist[nr][nc][cur.wall] > cur.len + 1){
                        q.add(new Pos(nr, nc, cur.len+1, cur.wall, !cur.isDaytime));
                        dist[nr][nc][cur.wall] = cur.len + 1;
                    }
                } else {
                    if(cur.wall < K){
                        if(dist[nr][nc][cur.wall+1] > cur.len + 1 && cur.isDaytime){
                            q.add(new Pos(nr, nc, cur.len+1, cur.wall+1, false));
                            dist[nr][nc][cur.wall+1] = cur.len + 1;
                        } else if(dist[nr][nc][cur.wall+1] > cur.len + 2 && !cur.isDaytime){
                            q.add(new Pos(nr, nc, cur.len+2, cur.wall+1, false));
                            dist[nr][nc][cur.wall+1] = cur.len + 2;
                        }
                    }
                }
            }
        }

        if(min == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(min);
    }

    static boolean isOutOfBound(int nr, int nc){
        return nr < 0 || nr >= N || nc < 0 || nc >= M;
    }
}
