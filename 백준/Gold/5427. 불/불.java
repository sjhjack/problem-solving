import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder ans = new StringBuilder();
    static final int[] dr = {-1,1,0,0};   // 상하좌우
    static final int[] dc = {0,0,-1,1};
    
    static int W, H;
    static char[][] arr;
    static boolean[][] isVisited;
    static Queue<Pos> fires;
    static Queue<Pos> mans;
    static boolean endFlag;

    static class Pos {
        int row;
        int col;
        int cnt;

        public Pos(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            init();
            solve();   
        }

        System.out.print(ans);
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        arr = new char[H][W];
        isVisited = new boolean[H][W];
        fires = new ArrayDeque<>();
        mans = new ArrayDeque<>();
        endFlag = false;

        for(int i = 0; i < H; i++) {
            arr[i] = br.readLine().toCharArray();

            for(int j = 0; j < W; j++) {
                if(arr[i][j] == '@') {
                    mans.add(new Pos(i, j, 0));
                } else if(arr[i][j] == '*') {
                    fires.add(new Pos(i, j, 0));
                }
            }
        }
    }

    static void solve() {
        while(!endFlag) {
            moveFire();
            moveMan();
        }
    }

    static void moveFire() {
        for(int i = fires.size(); i > 0; i--) {
            Pos fire = fires.poll();

            for(int d = 0; d < 4; d++) {
                int nr = fire.row + dr[d];
                int nc = fire.col + dc[d];

                if(nr < 0 || nr >= H || nc < 0 || nc >= W || arr[nr][nc]=='#' || arr[nr][nc]=='*') {
                    continue;
                }

                arr[nr][nc] = '*';
                fires.add(new Pos(nr, nc, 0));
            }
        }
    }

    static void moveMan() {        
        for(int i = mans.size(); i > 0; i--) {
            Pos man = mans.poll();

            for(int d = 0; d < 4; d++) {
                int nr = man.row + dr[d];
                int nc = man.col + dc[d];

                if(nr < 0 || nr >= H || nc < 0 || nc >= W) {
                    endFlag = true;
                    ans.append(man.cnt + 1).append("\n");
                    return;
                }
                
                if(arr[nr][nc]!='.') {
                    continue;
                }

                arr[nr][nc] = '@';
                mans.add(new Pos(nr, nc, man.cnt + 1));
            }
        }
        
        if(mans.isEmpty()) {
            endFlag = true;
            ans.append("IMPOSSIBLE\n");
        }
    }
}
