import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};    // 상하좌우
    static final int[] dc = {0,0,-1,1};

    static int R, C;
    static char[][] arr;
    static boolean[][] isWard;
    static Pos hanbyeol;
    static char[] command;

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
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        isWard = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken()) - 1;
        int col = Integer.parseInt(st.nextToken()) - 1;
        hanbyeol = new Pos(row, col);
        
        command = br.readLine().toCharArray();
    }

    static void solve() {
        for(int i = 0; i < command.length; i++) {
            char cmd = command[i];

            if(cmd == 'U') {
                hanbyeol.row += dr[0];
                hanbyeol.col += dc[0];
            } else if(cmd == 'D') {
                hanbyeol.row += dr[1];
                hanbyeol.col += dc[1];
            } else if(cmd == 'L') {
                hanbyeol.row += dr[2];
                hanbyeol.col += dc[2];
            } else if(cmd == 'R') {
                hanbyeol.row += dr[3];
                hanbyeol.col += dc[3];
            } else {
                if(!isWard[hanbyeol.row][hanbyeol.col]) {
                    markWard(hanbyeol.row, hanbyeol.col);
                }
            }
        }

        isWard[hanbyeol.row][hanbyeol.col] = true;
        
        for(int d = 0; d < 4; d++) {
            int nr = hanbyeol.row + dr[d];
            int nc = hanbyeol.col + dc[d];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            isWard[nr][nc] = true;
        }
    }

    static void markWard(int row, int col) {
        Queue<Pos> queue = new ArrayDeque<>();
        char alpha = arr[row][col];

        isWard[row][col] = true;
        queue.add(new Pos(row, col));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || isWard[nr][nc] || arr[nr][nc] != alpha) {
                    continue;
                }

                isWard[nr][nc] = true;
                queue.add(new Pos(nr, nc));
            }
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(isWard[i][j]) {
                    ans.append(".");
                } else {
                    ans.append("#");
                }
            }
            ans.append("\n");
        }

        System.out.print(ans);
    }
}
