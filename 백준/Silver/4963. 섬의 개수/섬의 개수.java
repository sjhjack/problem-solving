import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder ans = new StringBuilder();
    static final int[] dr = {-1,1,0,0,-1,-1,1,1};    // 상하좌우 좌상우상좌하우하
    static final int[] dc = {0,0,-1,1,-1,1,-1,1};

    static int W, H;
    static int[][] arr;
    static Queue<Pos> queue;
    static boolean[][] isVisited;

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) throws IOException {
        String s = "";

        while(!(s = br.readLine()).equals("0 0")) {
            init(s);
            solve();
        }

        System.out.print(ans);
    }

    static void init(String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        queue = new ArrayDeque<>();
        isVisited = new boolean[H][W];

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        int count = 0;

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(!isVisited[i][j] && arr[i][j] == 1) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        ans.append(count).append("\n");
    }

    static void bfs(int row, int col) {
        isVisited[row][col] = true;
        queue.add(new Pos(row, col));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int d = 0; d < 8; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= H || nc < 0 || nc >= W || isVisited[nr][nc] || arr[nr][nc] == 0) {
                    continue;
                }

                isVisited[nr][nc] = true;
                queue.add(new Pos(nr, nc));
            }
        }
    }
}
