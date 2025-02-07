import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};    // 상하좌우
    static final int[] dc = {0,0,-1,1};
    
    static int R, C;
    static char[][] arr;
    static Queue<Pos> waterQueue, swanQueue;
    static boolean[][] waterVisit, swanVisit;
    static Pos L1, L2;
    
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
        waterQueue = new ArrayDeque<>();
        swanQueue = new ArrayDeque<>();
        waterVisit = new boolean[R][C];
        swanVisit = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();

            for(int j = 0; j < C; j++) {
                if(arr[i][j] == 'L') {
                    if(L1 == null) {
                        L1 = new Pos(i, j);
                    } else {
                        L2 = new Pos(i, j);
                    }
                }
            }
        }
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(!waterVisit[i][j] && arr[i][j] != 'X') {
                    spreadToIce(waterQueue, waterVisit, i, j);
                }
            }
        }

        spreadToIce(swanQueue, swanVisit, L1.row, L1.col);
    }

    static void spreadToIce(Queue<Pos> targetQueue, boolean[][] targetVisit, int row, int col) {
        Queue<Pos> q = new ArrayDeque<>();
                    
        q.add(new Pos(row, col));
        targetVisit[row][col] = true;

        while(!q.isEmpty()) {
            Pos cur = q.poll();
            boolean nearX = false;

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || targetVisit[nr][nc]) {
                    continue;
                }
                
                if(arr[nr][nc] == 'X') {
                    nearX = true;
                } else {
                    q.add(new Pos(nr, nc));
                    targetVisit[nr][nc] = true;
                }
            }

            if(nearX) {
                targetQueue.add(cur);
            }
        }
    }

    static void solve() {
        int day = 1;

        while(true) {
            meltingIce();
            moveSwan();

            if(swanVisit[L2.row][L2.col]) {
                break;
            }

            day++;
        }

        System.out.print(day);
    }

    static void meltingIce() {
        for(int i = waterQueue.size(); i > 0; i--) {
            Pos cur = waterQueue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || waterVisit[nr][nc]) {
                    continue;
                }
                
                arr[nr][nc] = '.';
                waterQueue.add(new Pos(nr, nc));
                waterVisit[nr][nc] = true;
            }
        }
    }

    static void moveSwan() {
        for(int i = swanQueue.size(); i > 0; i--) {
            Pos cur = swanQueue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || swanVisit[nr][nc]) {
                    continue;
                }

                if(checkNewArea(nr, nc)) {
                    spreadToIce(swanQueue, swanVisit, nr, nc);
                } else {
                    swanQueue.add(new Pos(nr, nc));
                    swanVisit[nr][nc] = true;
                }
            }
        }
    }

    static boolean checkNewArea(int row, int col) {
        for(int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C || arr[nr][nc] == 'X' || swanVisit[nr][nc]) {
                continue;
            }

            return true;
        }

        return false;
    }
}
