import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    
    static char[][] arr;
    static boolean[][] isVisited;
    static Pos firstStudent;
    static int ans;

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

        arr = new char[5][5];
        isVisited = new boolean[5][5];

        for(int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }

    static void solve() {
        selectStudent(0, 0, 0, 0);
        System.out.print(ans);
    }

    static void selectStudent(int row, int col, int sCnt, int totCnt) {
        if(7 - totCnt + sCnt < 4) {
            return;
        }

        if(totCnt == 7) {
            if(checkValidation()) {
                ans++;
            }
            return;
        }

        for(int i = row; i < 5; i++) {
            for(int j = col; j < 5; j++) {
                int nextRow = i + (j + 1) / 5;
                int nextCol = (j + 1) == 5 ? 0 : j + 1;
                
                if(totCnt == 0) {
                    firstStudent = new Pos(i, j);
                }
                
                isVisited[i][j] = true;        
                selectStudent(nextRow, nextCol, sCnt + (arr[i][j] == 'S' ? 1 : 0), totCnt + 1);
                isVisited[i][j] = false;

                if(totCnt == 0) {
                    firstStudent = null;
                }
            }
            col = 0;
        }
    }

    static boolean checkValidation() {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] check = new boolean[5][5];
        int cnt = 1;
        
        check[firstStudent.row][firstStudent.col] = true;
        queue.add(firstStudent);

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || !isVisited[nr][nc] || check[nr][nc]) {
                    continue;
                }

                check[nr][nc] = true;
                cnt++;
                queue.add(new Pos(nr, nc));
            }
        }

        return cnt == 7;
    }
}
