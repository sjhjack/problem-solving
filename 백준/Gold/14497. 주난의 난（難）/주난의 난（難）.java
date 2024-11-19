import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};    // 상하좌우
    static final int[] dc = {0,0,-1,1};
    
    static int N, M;
    static char[][] arr;
    static Pos start, end;

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean isEnd(int nr, int nc) {
            return row == nr && col == nc;
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

        st = new StringTokenizer(br.readLine());
        start = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        end = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }

    static void solve() {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] isVisited;
        int cnt = 0;

        while(true) {
            isVisited = new boolean[N][M];
            cnt++;

            queue.add(start);
            isVisited[start.row][start.col] = true;

            while(!queue.isEmpty()) {
                Pos cur = queue.poll();

                for(int d = 0; d < 4; d++) {
                    int nr = cur.row + dr[d];
                    int nc = cur.col + dc[d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc]) {
                        continue;
                    }
                    
                    if(end.isEnd(nr, nc)) {
                        System.out.print(cnt);
                        return;
                    }

                    if(arr[nr][nc] == '0') {
                        queue.add(new Pos(nr, nc));
                        isVisited[nr][nc] = true;
                    } else if(arr[nr][nc] == '1') {
                        arr[nr][nc] = '0';
                        isVisited[nr][nc] = true;
                    }
                }
            }
        }
    }
}
