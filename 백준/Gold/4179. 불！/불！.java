import java.io.*;
import java.util.*;

class Main {

    static final int[] dr = {-1,1,0,0};    // 상하좌우
    static final int[] dc = {0,0,-1,1};

    static int R, C;
    static char[][] arr;
    static Queue<Pos> man, fire;
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
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        man = new ArrayDeque<>();
        fire = new ArrayDeque<>();
        isVisited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                arr[i][j] = tmp[j];
                
                if(arr[i][j] == 'J') {
                    man.add(new Pos(i, j));
                    isVisited[i][j] = true;
                } else if(arr[i][j] == 'F') {
                    fire.add(new Pos(i, j));
                    isVisited[i][j] = true;
                }
            }
        }
    }

    static void solve() {
        int ans = 0;

        while(true) {
            moveFire();
            int result = moveJihoon();
            
            if(result == 0){
                ans++;
            } else if(result == 1) {
                System.out.print(ans + 1);
                break;
            } else {
                System.out.print("IMPOSSIBLE");
                break;
            }
        }        
    }

    static void moveFire() {
        for(int i = fire.size(); i > 0; i--) {
            Pos cur = fire.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || isVisited[nr][nc] || arr[nr][nc] == '#') {
                    continue;
                }

                isVisited[nr][nc] = true;
                fire.add(new Pos(nr, nc));
            }
        }
    }

    static int moveJihoon() {
        int addCnt = 0;
        
        for(int i = man.size(); i > 0; i--) {
            Pos cur = man.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    return 1;
                }
                
                if(isVisited[nr][nc] || arr[nr][nc] == '#') {
                    continue;
                }

                isVisited[nr][nc] = true;
                man.add(new Pos(nr, nc));
                addCnt++;
            }
        }

        if(addCnt > 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
