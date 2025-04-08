import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};    // 상하좌우
    static final int[] dc = {0,0,-1,1};

    static int[][] arr;
    static boolean[][] isVisited;
    static boolean canEat;
    static int startRow, startCol;
    
    public static void main(String[] args) throws IOException {
        init();
        
        isVisited[startRow][startCol] = true;
        solve(startRow, startCol, 0, arr[startRow][startCol] == 1 ? 1 : 0);
        
        System.out.print(canEat ? 1 : 0);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[5][5];
        isVisited = new boolean[5][5];

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        startRow = Integer.parseInt(st.nextToken());
        startCol = Integer.parseInt(st.nextToken());
    }

    static void solve(int row, int col, int step, int apple) {
        if(canEat) {
            return;
        }

        if(step == 3) {
            if(apple >= 2) {
                canEat = true;
            }
            return;
        }

        for(int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || isVisited[nr][nc] || arr[nr][nc] < 0) {
                continue;
            }

            isVisited[nr][nc] = true;
            solve(nr, nc, step + 1, apple + (arr[nr][nc] == 1 ? 1 : 0));
            isVisited[nr][nc] = false;
        }
    }
}
